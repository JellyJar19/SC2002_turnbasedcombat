package battleEngine;

import combatant.*;
import action.*;
import items.*;
import java.util.List;
import java.util.ArrayList;


public class BattleEngine {
    private BattleContext context;
    private List<String> battleLog;

    public BattleEngine(BattleContext context) {
        this.context = context;
        this.battleLog = new ArrayList<>();
    }

    public BattleContext getContext() { return context; }
    public List<String> getBattleLog() { return battleLog; }
    public void clearLog() { battleLog.clear(); }

    // Process start of round: apply status effects that tick at start? Actually the spec says apply existing status effects first.
    // We'll implement a method to process status effects for all combatants at round start.
    public void processRoundStart() {
        // Apply status effects that are already active (like defense buff, etc.) - they are already applied.
        // Actually status effects are applied when created. The tick happens at end of turn.
        // For clarity, we do nothing extra here.
    }

    // Process a single turn for a given combatant (used by both player and enemies)
    public String processTurn(Combatant combatant) {
        if (!combatant.isAlive()) return combatant.getName() + " is dead, turn skipped.";
        if (combatant.getStun()) {
            combatant.setStun(false); // stun only lasts one turn? According to spec, stun lasts current and next turn.
            // Actually in your StunEffect, duration is 2, and it's cleared after ticks. We'll rely on effect manager.
            // But here we need to check if stun is active. We'll use combatant.getStun() which is set by effect.
            combatant.onEndTurn(); // tick effects
            return combatant.getName() + " is stunned and cannot act.";
        }
        // Decrease special cooldown if applicable
        combatant.decreaseCooldown();

        // Perform the turn - this will be overridden for player vs enemy.
        // We'll handle player turn separately via UI, and enemy turn here.
        // So we need to know if combatant is player or enemy.
        if (combatant == context.getPlayer()) {
            // Player turn is handled by UI calling executePlayerAction, not here.
            // So this method will only be called for enemies.
            return "Player turn should be handled by UI.";
        } else {
            // Enemy turn: always basic attack on player
            Action basic = new BasicAttack();
            boolean success = basic.execute(combatant, context.getPlayer(), context);
            combatant.onEndTurn(); // tick effects after action
            if (success) {
                return combatant.getName() + " used Basic Attack on " + context.getPlayer().getName();
            } else {
                return combatant.getName() + " failed to attack.";
            }
        }
    }

    // Execute a player-chosen action
    public String executePlayerAction(int actionIndex, int targetEnemyIndex, int itemIndex) {
        Combatant player = context.getPlayer();
        if (!player.isAlive()) return "Player is defeated, cannot act.";
        if (player.getStun()) {
            player.setStun(false);
            player.onEndTurn();
            return "Player is stunned and cannot act.";
        }
        player.decreaseCooldown();

        // Get available actions: basic attack, special skill, defend, use item
        // We'll define order: 0=BasicAttack, 1=SpecialSkill, 2=Defend, 3=UseItem
        String result = "";
        switch (actionIndex) {
            case 0: // Basic Attack
                if (targetEnemyIndex < 0 || targetEnemyIndex >= context.getEnemies().size()) {
                    return "Invalid target.";
                }
                Combatant target = context.getEnemies().get(targetEnemyIndex);
                if (!target.isAlive()) return "Target is already dead.";
                Action basic = new BasicAttack();
                basic.execute(player, target, context);
                result = player.getName() + " used Basic Attack on " + target.getName();
                break;
            case 1: // Special Skill
                Action special = player.getSpecialSkill();
                if (special == null) return "No special skill available.";
                if (player.getSpecialCooldown() > 0) return "Special skill on cooldown.";

                // For special skills that target all enemies (ArcaneBlast) or single (ShieldBash), we need to handle.
                // Since getSpecialSkill returns Action, we execute with target = first enemy? Better to have UI select.
                // We'll assume for Wizard (ArcaneBlast) target is ignored, for Warrior target is selected.

                Combatant specTarget = null;
                if (targetEnemyIndex >= 0 && targetEnemyIndex < context.getEnemies().size()) {
                    specTarget = context.getEnemies().get(targetEnemyIndex);
                } else if (player.getName().equals("Wizard")) {
                    // ArcaneBlast ignores target, but we still need a dummy.
                    specTarget = context.getEnemies().get(0);
                } else {
                    return "Invalid target for special skill.";
                }
                boolean success = special.execute(player, specTarget, context);
                if (success) {
                    result = player.getName() + " used " + special.getName() + " on " + (specTarget != null ? specTarget.getName() : "all enemies");
                } else {
                    result = "Special skill failed.";
                }
                break;
            case 2: // Defend
                Action defend = new Defend();
                defend.execute(player, player, context);
                result = player.getName() + " used Defend.";
                break;
            case 3: // Use Item
                List<Item> items = context.getPlayerItems();
                if (itemIndex < 0 || itemIndex >= items.size()) return "Invalid item.";
                Item item = items.get(itemIndex);
                // UseItem action expects an item in constructor. We need to create UseItem instance.
                UseItem useItem = new UseItem(item); // Ensure UseItem constructor is public.
                boolean used = useItem.execute(player, player, context);
                if (used) {
                    items.remove(itemIndex); // consume item
                    result = player.getName() + " used " + item.getName();
                } else {
                    result = "Failed to use item.";
                }
                break;
            default:
                return "Unknown action.";
        }
        player.onEndTurn(); // tick status effects after action
        // After player action, check if enemies all dead -> may trigger backup spawn
        if (context.areAllEnemiesDefeated()) {
            context.spawnBackup();
        }
        return result;
    }

    // Process all enemy turns in order (until next player turn)
    // Returns list of log messages for each enemy turn.
    public List<String> processEnemyTurns() {
        List<String> logs = new ArrayList<>();
        // Get current turn order, and process from current index until we reach player again.
        List<Combatant> turnOrder = context.getTurnOrder();
        int startIdx = context.getCurrentTurnIndex();
        int idx = startIdx;
        do {
            Combatant c = turnOrder.get(idx);
            if (c != context.getPlayer() && c.isAlive()) {
                // Enemy turn
                if (c.getStun()) {
                    c.setStun(false);
                    c.onEndTurn();
                    logs.add(c.getName() + " is stunned, turn skipped.");
                } else {
                    c.decreaseCooldown();
                    Action basic = new BasicAttack();
                    basic.execute(c, context.getPlayer(), context);
                    c.onEndTurn();
                    logs.add(c.getName() + " used Basic Attack on " + context.getPlayer().getName());
                }
                // After each enemy, check if player died
                if (context.isPlayerDefeated()) break;
                // Check if all enemies dead (possible if special skill killed last enemy during player turn, but here enemy turns only)
                if (context.areAllEnemiesDefeated()) break;
            }
            idx = (idx + 1) % turnOrder.size();
        } while (idx != startIdx && !context.isPlayerDefeated() && !context.areAllEnemiesDefeated());
        // Update current turn index to the next player (or after last enemy)
        // We'll set to the index of player in turn order.
        for (int i = 0; i < turnOrder.size(); i++) {
            if (turnOrder.get(i) == context.getPlayer()) {
                context.setCurrentTurnIndex(i);
                break;
            }
        }
        return logs;
    }

    // Check if battle is over, return "win", "lose", or null.
    public String getBattleOutcome() {
        if (context.isPlayerDefeated()) return "lose";
        if (context.areAllEnemiesDefeated()) return "win";
        return null;
    }

    // Get list of available actions for player (as strings)
    public List<String> getPlayerActionNames() {
        List<String> actions = new ArrayList<>();
        actions.add("Basic Attack");
        if (context.getPlayer().getSpecialSkill() != null && context.getPlayer().getSpecialCooldown() == 0) {
            actions.add("Special Skill");
        } else if (context.getPlayer().getSpecialSkill() != null) {
            actions.add("Special Skill (on cooldown)");
        } else {
            actions.add("Special Skill (unavailable)");
        }
        actions.add("Defend");
        actions.add("Use Item");
        return actions;
    }

    // Get list of alive enemies for targeting
    public List<Combatant> getAliveEnemies() {
        List<Combatant> alive = new ArrayList<>();
        for (Combatant e : context.getEnemies()) {
            if (e.isAlive()) alive.add(e);
        }
        return alive;
    }
}

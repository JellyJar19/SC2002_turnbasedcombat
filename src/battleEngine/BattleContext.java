package battleEngine;

import combatant.Combatant;
import items.Item;
import java.util.List;
import java.util.ArrayList;

public class BattleContext {
    private Combatant player;
    private List<Combatant> enemies;
    private List<Combatant> turnOrder;
    private int currentTurnIndex;
    private int round;
    private int difficulty; // 1=Easy, 2=Medium, 3=Hard
    private List<Item> playerItems;
    private boolean backupSpawned;
    private List<Combatant> backupEnemies; // to spawn after initial wave defeated

    public BattleContext(Combatant player, List<Combatant> enemies, int difficulty, List<Item> items) {
        this.player = player;
        this.enemies = new ArrayList<>(enemies);
        this.difficulty = difficulty;
        this.playerItems = new ArrayList<>(items);
        this.round = 1;
        this.backupSpawned = false;
        this.backupEnemies = new ArrayList<>();
        this.turnOrder = new ArrayList<>();
        updateTurnOrder();
        this.currentTurnIndex = 0;
    }

    public Combatant getPlayer() { return player; }
    public List<Combatant> getEnemies() { return enemies; }
    public List<Combatant> getTurnOrder() { return turnOrder; }
    public int getCurrentTurnIndex() { return currentTurnIndex; }
    public void setCurrentTurnIndex(int idx) { currentTurnIndex = idx; }
    public int getRound() { return round; }
    public void incrementRound() { round++; }
    public int getDifficulty() { return difficulty; }
    public List<Item> getPlayerItems() { return playerItems; }
    public boolean isBackupSpawned() { return backupSpawned; }
    public void setBackupSpawned(boolean spawned) { backupSpawned = spawned; }
    public List<Combatant> getBackupEnemies() { return backupEnemies; }
    public void setBackupEnemies(List<Combatant> backup) { backupEnemies = backup; }

    // Recalculate turn order based on speed (higher first)
    public void updateTurnOrder() {
        List<Combatant> all = new ArrayList<>();
        all.add(player);
        all.addAll(enemies);
        all.sort((a, b) -> Integer.compare(b.getSpeed(), a.getSpeed()));
        turnOrder = all;
    }

    // Get next alive combatant in turn order (cyclic)
    public Combatant getNextAliveCombatant() {
        for (int i = 0; i < turnOrder.size(); i++) {
            int idx = (currentTurnIndex + i) % turnOrder.size();
            Combatant c = turnOrder.get(idx);
            if (c.isAlive()) return c;
        }
        return null;
    }

    // Advance to next alive combatant's turn
    public void advanceTurn() {
        do {
            currentTurnIndex = (currentTurnIndex + 1) % turnOrder.size();
        } while (!turnOrder.get(currentTurnIndex).isAlive());
    }

    // Check win/loss
    public boolean isPlayerDefeated() { return !player.isAlive(); }
    public boolean areAllEnemiesDefeated() {
        for (Combatant e : enemies) {
            if (e.isAlive()) return false;
        }
        return true;
    }

    // Spawn backup enemies (called when initial wave defeated and backup exists)
    public void spawnBackup() {
        if (!backupSpawned && !backupEnemies.isEmpty()) {
            enemies.addAll(backupEnemies);
            backupSpawned = true;
            updateTurnOrder();
        }
    }
}

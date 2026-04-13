package mainMenu;

import battleEngine.BattleContext;
import battleEngine.BattleEngine;
import combatant.*;
import items.*;
import java.util.*;

public class UI {
    private Scanner scanner;
    private BattleEngine engine;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Turn-Based Combat Arena ===");
        boolean exit = false;
        while (!exit) {
            // Character selection
            Combatant player = selectCharacter();
            // Item selection
            List<Item> items = selectItems();
            // Difficulty selection
            int difficulty = selectDifficulty();
            // Enemy spawn based on difficulty
            List<Combatant> enemies = spawnEnemies(difficulty);
            List<Combatant> backup = getBackupEnemies(difficulty);
            
            BattleContext context = new BattleContext(player, enemies, difficulty, items);
            context.setBackupEnemies(backup);
            engine = new BattleEngine(context);
            
            // Run battle
            boolean victory = runBattle();
            
            // End screen
            showEndScreen(victory, engine.getContext().getRound(), 
                          engine.getContext().getPlayer().getHp(),
                          engine.getContext().getEnemies().stream().filter(e -> e.isAlive()).count());
            
            // Replay option
            System.out.print("Replay with same settings? (1=Yes, 2=New Game, 3=Exit): ");
            int choice = scanner.nextInt();
            if (choice == 2) continue;
            else if (choice == 3) exit = true;
            else if (choice == 1) {
                // Re-run same battle (reinitialize)
                continue;
            }
        }
        scanner.close();
    }
    
    private Combatant selectCharacter() {
        System.out.println("Choose your class:");
        System.out.println("1. Warrior (HP:260, ATK:40, DEF:20, SPD:30)");
        System.out.println("2. Wizard (HP:200, ATK:50, DEF:10, SPD:20)");
        int choice;
        while(true){
            try{
                choice = scanner.nextInt();
                if (choice==1)
                    return new Warrior();
                else if (choice == 2)
                    return new Wizard();
                else
                    System.out.println("Enter a number between 1 and 6 only!");
            }
            catch(InputMismatchException e){
                scanner.next(); //clear the error line
                System.out.println("Enter integers only!");
            }
        }
    }
    
    private List<Item> selectItems() {
        List<Item> items = new ArrayList<>();
        System.out.println("Choose two items (duplicates allowed):");
        System.out.println("1. Potion (heal 100 HP)");
        System.out.println("2. Smoke Bomb (invulnerability for 2 turns)");
        System.out.println("3. Power Stone (use special skill without cooldown)");
        for (int i = 0; i < 2; i++) {
            int choice;
            while(true){
                System.out.print("Item " + (i+1) + ": ");
                try{
                    choice = scanner.nextInt();
                    if (choice == 1){
                        items.add(new Potion());
                        break;
                    }
                    else if (choice == 2){
                        items.add(new SmokeBomb());
                        break;
                    }
                        
                    else if (choice == 3){
                        items.add(new PowerStone());
                        break;
                    }
                    else
                        System.out.println("Only numbers 1 to 3 allowed!");
                    
                    
                }
                catch(InputMismatchException e){
                    scanner.next(); //clear the error line
                    System.out.println("Enter integers only!");
                }
            }
        }
        return items;
    }
    
    private int selectDifficulty() {
        System.out.println("Select difficulty:");
        System.out.println("1. Easy (3 Goblins)");
        System.out.println("2. Medium (1 Goblin + 1 Wolf, backup: 2 Wolves)");
        System.out.println("3. Hard (2 Goblins, backup: 1 Goblin + 2 Wolves)");
        return scanner.nextInt();
    }
    
    private List<Combatant> spawnEnemies(int difficulty) {
        List<Combatant> enemies = new ArrayList<>();
        if (difficulty == 1) {
            for (int i = 0; i < 3; i++) enemies.add(new Goblin());
        } else if (difficulty == 2) {
            enemies.add(new Goblin());
            enemies.add(new Wolf());
        } else if (difficulty == 3) {
            enemies.add(new Goblin());
            enemies.add(new Goblin());
        }
        return enemies;
    }
    
    private List<Combatant> getBackupEnemies(int difficulty) {
        List<Combatant> backup = new ArrayList<>();
        if (difficulty == 2) {
            backup.add(new Wolf());
            backup.add(new Wolf());
        } else if (difficulty == 3) {
            backup.add(new Goblin());
            backup.add(new Wolf());
            backup.add(new Wolf());
        }
        return backup;
    }
    
    private boolean runBattle() {
        System.out.println("\n=== BATTLE START ===");
        while (true) {
            // Round start
            System.out.println("\n--- Round " + engine.getContext().getRound() + " ---");
            engine.processRoundStart();
            engine.getContext().updateTurnOrder();
            
            // Player turn
            boolean playerActed = false;
            while (!playerActed) {
                displayStatus();
                List<String> actions = engine.getPlayerActionNames();
                System.out.println("Choose action:");
                for (int i = 0; i < actions.size(); i++) {
                    System.out.println((i+1) + ". " + actions.get(i));
                }
                int actionChoice = scanner.nextInt() - 1;
                if (actionChoice < 0 || actionChoice >= actions.size()) continue;
                
                int targetIdx = -1;
                int itemIdx = -1;
                if (actionChoice == 0 || actionChoice == 1) { // basic or special skill
                    List<Combatant> enemies = engine.getAliveEnemies();
                    if (enemies.isEmpty()) break;
                    System.out.println("Select target:");
                    for (int i = 0; i < enemies.size(); i++) {
                        Combatant e = enemies.get(i);
                        System.out.println((i+1) + ". " + e.getName() + " (HP: " + e.getHp() + ")");
                    }
                    targetIdx = scanner.nextInt() - 1;
                    if (targetIdx < 0 || targetIdx >= enemies.size()) continue;
                    // Map to actual enemy index in context
                    targetIdx = engine.getContext().getEnemies().indexOf(enemies.get(targetIdx));
                }
                if (actionChoice == 3) { // use item
                    List<Item> items = engine.getContext().getPlayerItems();
                    if (items.isEmpty()) {
                        System.out.println("No items left!");
                        continue;
                    }
                    System.out.println("Select item:");
                    for (int i = 0; i < items.size(); i++) {
                        System.out.println((i+1) + ". " + items.get(i).getName());
                    }
                    itemIdx = scanner.nextInt() - 1;
                    if (itemIdx < 0 || itemIdx >= items.size()) continue;
                }
                String result = engine.executePlayerAction(actionChoice, targetIdx, itemIdx);
                System.out.println(result);
                playerActed = true;
            }
            
            // Check win/loss after player turn
            String outcome = engine.getBattleOutcome();
            if (outcome != null) return outcome.equals("win");
            
            // Enemy turns
            List<String> enemyLogs = engine.processEnemyTurns();
            for (String log : enemyLogs) System.out.println(log);
            
            // Check again
            outcome = engine.getBattleOutcome();
            if (outcome != null) return outcome.equals("win");
            
            engine.getContext().incrementRound();
        }
    }
    
    private void displayStatus() {
    Combatant player = engine.getContext().getPlayer();
    
    // Header
    System.out.println("\n========================================");
    System.out.println("PLAYER STATUS: " + player.getName());
    System.out.println("HP: " + player.getHp() + "/" + player.getMaxHp());
    
    // Display current stats (will show changes from buffs/debuffs)
    System.out.println("ATK: " + player.getBaseAttack() + " | DEF: " + player.getBaseDefense());
    
    // Display Cooldown
    String cdStatus = (player.getSpecialCooldown() == 0) ? "READY" : player.getSpecialCooldown() + " turns left";
    System.out.println("Special Cooldown: " + cdStatus);
    
    // Show active status effects from our EffectManager
    List<String> effects = player.getStatusDescriptions();
    if (!effects.isEmpty()) {
        System.out.println("Active Effects: " + String.join(", ", effects));
    } else {
        System.out.println("Active Effects: None");
    }
    
    // Item count
    System.out.println("Items: " + engine.getContext().getPlayerItems().size() + " remaining");
    System.out.println("========================================");

    // Enemy List
    System.out.println("ENEMIES:");
    for (Combatant e : engine.getContext().getEnemies()) {
        if (e.isAlive()) {
            System.out.println(" - " + e.getName() + " [HP: " + e.getHp() + "/" + e.getMaxHp() + "]");
        }
    }
    System.out.println("========================================\n");
}
    
    private void showEndScreen(boolean victory, int rounds, int remainingHp, long enemiesRemaining) {
        if (victory) {
            System.out.println("\n=== VICTORY! ===");
            System.out.println("Congratulations, you have defeated all your enemies.");
            System.out.println("Remaining HP: " + remainingHp);
            System.out.println("Total Rounds: " + rounds);
        } else {
            System.out.println("\n=== DEFEAT ===");
            System.out.println("Defeated. Don't give up, try again!");
            System.out.println("Enemies remaining: " + enemiesRemaining);
            System.out.println("Total Rounds Survived: " + rounds);
        }
    }
    
    public static void main(String[] args) {
        UI ui = new UI();
        ui.start();
    }
}
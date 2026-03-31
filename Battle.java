public class Battle {
    Combatant[] currentEnemies = new Combatant[5];
    Combatant currentAllies;
    Item[] currentItems = new Item[2];
    Combatant[] roundOrder = new Combatant[6];
    int roundNumber;
    int backupEnemies;


    Battle(Player playerChar, Item[] playerItems, Level difficultyLevel) {
        currentAllies = playerChar;
        difficultyLevel.spawnEnemies(currentEnemies);
        currentItems = playerItems;
        roundNumber = 1;
        backupEnemies = difficultyLevel.getBackupStatus();
        Battle_Engine.TurnOrderStrategy(roundOrder, currentAllies, currentEnemies);
    }
}
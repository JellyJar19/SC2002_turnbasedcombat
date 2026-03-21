public class Battle {
    Entity[] currentEnemies = new Entity[5];
    Entity[] currentAllies;
    Item[] currentItems = new Item[2];
    Entity[] roundOrder = new Entity[6];
    int roundNumber;
    int backupEnemies;


    Battle(Playable[] playerChar, Item[] playerItems, Level[] difficultyLevel) {
        currentAllies = playerChar;
        difficultyLevel[0].spawnEnemies(currentEnemies);
        currentItems = playerItems;
        roundNumber = 1;
        backupEnemies = difficultyLevel[0].getBackupStatus();
        Battle_Engine.TurnOrderStrategy(roundOrder, currentAllies, currentEnemies);
    }
}
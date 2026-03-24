public class Level {
    int backupEnemies = 0;   //if 0 this level has no backup enemies. otherwise, backup enemies can spawn.
    String difficultyName;

    Level(int difficulty) {
        switch(difficulty) {
            case 1: {
                difficultyName = "EASY";
                break;
            }
            case 2: {
                difficultyName = "MEDIUM";
                backupEnemies = 1;
                break;
            }
            case 3: {
                difficultyName = "HARD";
                backupEnemies = 1;
            }
        }
    }

    
    public String getLevel()  {
        return difficultyName;
    }
    public int getBackupStatus() {
        return backupEnemies;
    }
    public void setDifficulty(int difficulty) {
        switch(difficulty) {
            case 1: {
                difficultyName = "EASY";
                break;
            }
            case 2: {
                difficultyName = "MEDIUM";
                backupEnemies = 1;
                break;
            }
            case 3: {
                difficultyName = "HARD";
                backupEnemies = 1;
            }
        }
    } 

    public void spawnEnemies(Entity[] currentEnemies) {
        switch(this.difficultyName) {
            case "EASY": {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Goblin();
                currentEnemies[2] = new Goblin();
                break;
            }
            case "MEDIUM": {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Wolf();
                break;
            }
            default: {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Goblin();
                break;
            }
        }
        return;
    }

    public void spawnBackupEnemies(Entity[] currentEnemies) {
        switch(this.difficultyName) {
            case "EASY": {
                return;
            }
            case "MEDIUM": {
                currentEnemies[0] = new Wolf();
                currentEnemies[1] = new Wolf();
                return;
            }
            default: {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Wolf();
                currentEnemies[2] = new Wolf();
                return;
            }
        }   
    }
}

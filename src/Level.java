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

    public void spawnEnemies(Combatant[] currentEnemies) {
        switch(this.difficultyName) {
            case "EASY": {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Goblin();
                currentEnemies[2] = new Goblin();
                for (int i = 3; i < ConstantsClass.MAXENEMIES; i++) {
                    currentEnemies[i] = null;
                }
                break;
            }
            case "MEDIUM": {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Wolf();
                for (int i = 2; i < ConstantsClass.MAXENEMIES; i++) {
                    currentEnemies[i] = null;
                }
                break;
            }
            default: {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Goblin();
                for (int i = 2; i < ConstantsClass.MAXENEMIES; i++) {
                    currentEnemies[i] = null;
                }
                break;
            }
        }
        return;
    }

    public void spawnBackupEnemies(Combatant[] currentEnemies) {
        switch(this.difficultyName) {
            case "MEDIUM": {
                currentEnemies[0] = new Wolf();
                currentEnemies[1] = new Wolf();
                for (int i = 2; i < ConstantsClass.MAXENEMIES; i++) {
                    currentEnemies[i] = null;
                }
                backupEnemies = 0;
                return;
            }
            default: {
                currentEnemies[0] = new Goblin();
                currentEnemies[1] = new Wolf();
                currentEnemies[2] = new Wolf();
                for (int i = 3; i < ConstantsClass.MAXENEMIES; i++) {
                    currentEnemies[i] = null;
                }
                backupEnemies = 0;
                return;
            }
        }   
    }
}

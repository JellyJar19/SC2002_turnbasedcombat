package src.level;

import src.entities.Combatant;
import src.constClass.ConstantsClass;

public class Level {
    private DifficultyLevel difficulty;
    private boolean backupsTriggered;

    public Level(DifficultyLevel difficulty) {
        this.difficulty = difficulty;
        this.backupsTriggered = false;
    }

    public String getLevelName() {
        return difficulty.getLevelName();
    }

    //fill empty slots in array with null
    private void fillEnemyArray(Combatant[] targetArray, Combatant[] spawns) {
        for (int i = 0; i < ConstantsClass.MAXENEMIES; i++) {
            if (i < spawns.length) {
                targetArray[i] = spawns[i];
            } else {
                targetArray[i] = null;
            }
        }
    }

    public void spawnEnemies(Combatant[] currentEnemies) {
        Combatant[] spawns = difficulty.getInitialSpawns();
        fillEnemyArray(currentEnemies, spawns);
    }

    public void spawnBackupEnemies(Combatant[] currentEnemies) {
        Combatant[] spawns = difficulty.getBackupSpawns();
        fillEnemyArray(currentEnemies, spawns);
        this.backupsTriggered = true; // Mark that backups have arrived
    }

    // Safely checks if backups exist AND haven't been used yet
    public boolean hasAvailableBackups() {
        return difficulty.hasBackupSpawns() && !this.backupsTriggered;
    }
}
package src.level;

import src.entities.Combatant;

public interface DifficultyLevel {
    String getLevelName();
    
    Combatant[] getInitialSpawns();
    
    Combatant[] getBackupSpawns();
    
    boolean hasBackupSpawns();
}


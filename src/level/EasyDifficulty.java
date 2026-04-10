package src.level;

import src.entities.Combatant;
import src.entities.enemy.Goblin;

public class EasyDifficulty implements DifficultyLevel { 
    public String getLevelName() { 
        return "EASY"; 
    }

    public Combatant[] getInitialSpawns() {
        // Based on rubric: 3 Goblins
        Combatant[] combatant = { new Goblin(), new Goblin(), new Goblin() };
        return combatant;
    }

    public Combatant[] getBackupSpawns() {
        return new Combatant[0]; // No backups for Easy
    }

    public boolean hasBackupSpawns() { 
        return false; 
    }
}

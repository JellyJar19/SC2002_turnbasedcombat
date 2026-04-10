package level;

import src.entities.Combatant;
import src.entities.enemy.Goblin;
import src.entities.enemy.Wolf;

public class MediumDifficulty implements DifficultyLevel {

    @Override
    public String getLevelName() { 
        return "MEDIUM"; 
    }

    @Override
    public Combatant[] getInitialSpawns() {
        return new Combatant[] { new Goblin(), new Wolf() };
    }

    @Override
    public Combatant[] getBackupSpawns() {
        return new Combatant[] { new Wolf(), new Wolf() };
    }

    @Override
    public boolean hasBackupSpawns() { 
        return true; 
    }
}
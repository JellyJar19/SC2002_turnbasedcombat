package action;
import statusEffects.*;
import combatant.*;

public interface Action{
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle);
    public String getName();
}
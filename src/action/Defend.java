package action;
import statusEffects.*;
import entities.*;

public class Defend implements Action{
    @Override
    public <T> boolean execute(T activechar, T target, BattleContext battle) {
        DefenseBuffEffect df = new DefenseBuffEffect();
        activechar.addStatusEffect(df);
        return true;
    }
    @Override
    public string getName() {
        return "Defend";
    }
}

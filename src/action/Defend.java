package action;
import statusEffects.*;
import entities.*;

public class Defend implements Action{
    @Override
    public <T> boolean execute(T activechar, T target, Battle battle) {
        
        return true;
    }
    @Override
    public string getName() {
        return "Defend";
    }
}

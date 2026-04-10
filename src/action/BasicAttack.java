package action;
import statusEffects.*;
import entities.*;

public class BasicAttack implements Action{
    @Override
    public <T> boolean execute(T activechar, T target, Battle battle){
        int atk = activechar.getAttack();
        int def = target.getDefense();
        int dmg = Math.max(0,atk - def);
        target.takeDamage(dmg);
    }
    @Override
    public string getName(){
        return "Basic Attack";
    }
}
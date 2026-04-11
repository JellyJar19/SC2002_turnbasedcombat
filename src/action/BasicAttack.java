package action;
import statusEffects.*;
import entities.*;

public class BasicAttack implements Action{
    private int dmg;
    @Override
    public <T> boolean execute(T activechar, T target, Battle battle){
        int atk = activechar.getAttack();
        int def = target.getDefense();
        this.dmg = Math.max(0,atk - def);
        target.takeDamage(this.dmg);
    }
    @Override
    public string getName(){
        return "Basic Attack";
    }
    public int getDamage(){
        return dmg;
    }
}

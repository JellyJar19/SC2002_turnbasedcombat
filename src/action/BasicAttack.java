package action;
import statusEffects.*;
import combatant.*;

public class BasicAttack extends AbstractActions{
    private int dmg;
    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle){
        this.dmg = calculateDamage(activechar, target);
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

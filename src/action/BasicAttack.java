package action;

import combatant.*;
import battleEngine.*;

public class BasicAttack extends AbstractActions{
    private int dmg;

    public BasicAttack(){ //remove the parameters
        this.dmg = 0;
    }
    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle){
        this.dmg = calculateDamage(activechar, target);
        target.takeDamage(this.dmg);
        return true;
    }
    @Override
    public String getName(){
        return "Basic Attack";
    }
    public int getDamage(){
        return dmg;
    }
}

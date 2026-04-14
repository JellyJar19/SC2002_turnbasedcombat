package action;
import statusEffects.*;
import combatant.*;
import battleEngine.*;

public class Defend extends AbstractActions{
    public Defend(){
    }

    @Override
    public boolean execute(Combatant user, Combatant target, BattleContext context) {
    // Apply a buff that lasts only 1 turn
    StatusEffects defenseBuff = new DefenseBuffEffect(); 
    user.applyStatusEffect(defenseBuff); 
    return true;
}
    @Override
    public String getName() {
        return "Defend";
    }
}

package combatant;

import action.*;
import battleEngine.*;

public class Wolf extends Combatant{

    public Wolf() {
        super("Wolf", 40, 45, 5, 35);
    }

    @Override
    public Action getSpecialSkill() {
        return null;
    }  
    
    @Override
    public void performTurn(BattleContext context) {
        if (this.canAct()) {
        new BasicAttack().execute(this, context.getPlayer(), context);
        }
    }

    

}

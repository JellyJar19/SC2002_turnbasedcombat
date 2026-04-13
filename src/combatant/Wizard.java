package combatant;

import action.ArcaneBlast;
import action.*;
import battleEngine.*;

public class Wizard extends Combatant {
    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
        this.setDefaultActions();
        this.addAvailableActions(new ArcaneBlast());
    }

    @Override
    public Action getSpecialSkill() {
        return new ArcaneBlast();
    }

    @Override
    public void performTurn(BattleContext context) {
        //to be implemented
        // switch (playerinput){
        //     case 1: {
        //          select target 
        //          this.executeAction(BasicAttack, target, context);
        //     }
        //     case 2: {
        //          select target
        //          this.executeAction(SpecialSkill, target, context);
        //     }
        //     case 3: {
        //          this.executeAction(Defend, this, context);
        //     }
        // case 4: {
        //          this.executeAction(UseItem, this, context);
        //          if item is powerstone, select target and executeAction(SpecialSkill, target, context);
        //     }
        //     default: {null}
        // }

    }
}
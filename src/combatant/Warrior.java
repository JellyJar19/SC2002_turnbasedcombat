package combatant;

import action.*;
import statusEffects.*;
import battleEngine.*;

public class Warrior extends Combatant {
    public Warrior() {
        super("Warrior", 260, 40, 20, 30);
        this.setDefaultAction();
        this.addAvailableAction(new ShieldBash());
    }

    @Override
    public Action getSpecialSkill() {
        return new ShieldBash();
    }

    @Override
    public void performTurn(BattleContext context) {
        //to be implemented
        // should we implement this as a case statement based on the action chosen by the player?
    }

}

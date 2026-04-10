package src.combatant;

import action.ArcaneBlast;
import src.action.*;

public class Wizard extends Combatant {
    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
    }

    @Override
    public Action getSpecialSkill() {
        return new ArcaneBlast();
    }

    @Override
    public void performTurn(BattleContext context) {
        //to be implemented
    }

}

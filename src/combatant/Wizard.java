package combatant;

import action.ArcaneBlast;
import action.*;
import battleEngine.*;

public class Wizard extends Combatant {
    public Wizard() {
        super("Wizard", 200, 50, 10, 20);
        this.addAvailableActions((Action)new ArcaneBlast());
    }

    @Override
    public Action getSpecialSkill() {
        return new ArcaneBlast();
    }

    @Override
    public void performTurn(BattleContext context) {
        // handled by UI 
    }
}

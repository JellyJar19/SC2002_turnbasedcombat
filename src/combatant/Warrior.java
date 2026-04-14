package combatant;

import action.*;
import battleEngine.*;

public class Warrior extends Combatant {
    public Warrior() {
        super("Warrior", 260, 40, 20, 30);
        this.addAvailableActions((Action) new ShieldBash());
    }

    @Override
    public Action getSpecialSkill() {
        return new ShieldBash();
    }

    @Override
    public void performTurn(BattleContext context) {
        // handled by UI 
    }

}

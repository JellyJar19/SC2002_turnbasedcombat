package items;

import combatant.*;
import battleEngine.*;

public class Potion implements Item {
    private int healAmount = 100;

    public String getName() {
        return("Potion");
    }

    @Override
    public boolean use(Combatant user, Combatant target, BattleContext context) {
        target.heal(healAmount);
        return true;
    }


}

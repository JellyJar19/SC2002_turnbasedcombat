package items;

import combatant.*;
import battleEngine.*;

public class Potion implements Item {
    private int healAmount = 100;

    public String getName() {
        return("Potion");
    }

    @Override
    public boolean use(Combatant user, BattleContext context) {
        user.heal(healAmount);
        return true;
    }


}

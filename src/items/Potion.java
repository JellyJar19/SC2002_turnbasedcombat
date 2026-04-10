package src.items;

import src.combatant.*;

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

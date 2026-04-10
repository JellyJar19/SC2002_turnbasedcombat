package src.items;

import src.combatant.*;
import src.statusEffects.*;

public class SmokeBomb implements Item {
    public String getName() {
        return("Smoke Bomb");
    }

    @Override
    public boolean use(Combatant user, BattleContext context) {
        user.addStatusEffect(new SmokeBombEffect());
        return true;
    }

}

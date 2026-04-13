package items;

import combatant.*;
import statusEffects.*;
import battleEngine.*;

public class SmokeBomb implements Item {
    public String getName() {
        return("Smoke Bomb");
    }

    @Override
    public boolean use(Combatant user, Combatant target, BattleContext context) {
        user.applyStatusEffect(new InvulnerabilityEffect());
        return true;
    }

}

package items;

import combatant.*;
import action.*;
import battleEngine.*;

public class PowerStone implements Item {
    public String getName() {
        return("Power Stone");
    }

    @Override
    public boolean use(Combatant user, BattleContext context) {
        Action specialSkill = user.getSpecialSkill();
        if (specialSkill == null) return false;
        // Use first alive enemy as target placeholder; ArcaneBlast ignores it and hits all enemies internally
        Combatant target = context.getEnemies().stream()
                .filter(e -> e.isAlive())
                .findFirst()
                .orElse(user);
        // Bypass cooldown: temporarily set cooldown to 0 so the skill fires
        user.setSpecialCooldown(0);
        return specialSkill.execute(user, target, context);
    }
}

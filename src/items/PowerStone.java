package items;

import combatant.*;
import action.*;

public class PowerStone implements Item {
    public String getName() {
        return("Power Stone");
    }

    @Override
    public boolean use(Combatant user, BattleContext context) {
        Action specialSkill = user.getSpecialSkill();
        return(specialSkill.execute(user, context));
    }
}

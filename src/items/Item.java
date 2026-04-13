package items;

import combatant.*;
import battleEngine.*;

public interface Item {
    public String getName();
    public boolean use(Combatant user, Combatant target, BattleContext context);
}

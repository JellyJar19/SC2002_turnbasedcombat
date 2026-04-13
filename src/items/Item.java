package items;

import combatant.*;

public interface Item {
    public String getName();
    public boolean use(Combatant user, BattleContext context);
}

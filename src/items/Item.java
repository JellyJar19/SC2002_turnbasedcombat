package items;

import combatant.Combatant;

public interface Item {
    public String getName();
    public boolean use(Combatant user, BattleContext context);
}

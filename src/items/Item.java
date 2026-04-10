package src.items;

import src.combatant.Combatant;

public interface Item {
    public String getName();
    public boolean use(Combatant user, BattleContext context);
}

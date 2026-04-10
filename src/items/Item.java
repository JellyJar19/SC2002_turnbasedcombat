package src.items;

public interface Item {
    public String getName();
    public void use(Combatant, BattleContext);
}

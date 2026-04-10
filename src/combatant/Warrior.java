package src.combatant;

import src.action.*;

public class Warrior extends Combatant {
    public Warrior() {
        super("Warrior", 260, 40, 20, 30);
    }

    @Override
    public Action getSpecialSkill() {
        return new ShieldBash();
    }

    @Override
    public void performTurn(BattleContext context) {
        //to be implemented
    }

}

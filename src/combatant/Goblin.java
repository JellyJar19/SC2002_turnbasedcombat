package src.combatant;

import src.action.*;

public class Goblin extends Combatant{

    public Goblin() {
        super("Goblin", 55, 35, 15, 25);
    }

    @Override
    public Action getSpecialSkill() {
        return null;
    }  
    
    @Override
    public void performTurn(BattleContext context) {
        //to be implemented
    }

}
package src.combatant;

import src.action.*;

public class Wolf extends Combatant{

    public Wolf() {
        super("Wolf", 40, 45, 5, 35);
        this.setDefaultActions();
    }

    @Override
    public Action getSpecialSkill() {
        return null;
    }  
    
    @Override
    public void performTurn(BattleContext context) {
        //to be implemented
        // refer to Goblin class for the expected battle strategy. 
    }

    

}

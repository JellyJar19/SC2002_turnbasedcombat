package src.combatant;

import src.action.*;

public class Goblin extends Combatant{

    public Goblin() {
        super("Goblin", 55, 35, 15, 25);
        this.setDefaultActions();
    }

    @Override
    public Action getSpecialSkill() {
        return null;
    }  
    
    @Override
    public void performTurn(BattleContext context) {
        //to be implemented
        // Depends on implementation of BasicAttackStrategy because otherwise we can just loop through playerlist and attack first one
        // i.e. the code will end up looking like:
        // while playerList is not empty:
        //     take first player in list
        //     this.executeAction(BasicAttack, player, context);
        //    end while
    }

}
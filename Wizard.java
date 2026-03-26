import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public class Wizard extends Player {
    private int arcaneBlastBonus;

    public Wizard(String name){
        super(name, 200, 50, 10, 20);\
        this.arcaneBlastBonus = 0;
    }

    public List<Action> getAvailActions(){
        // waiting for the class to be made
        List<Action> action = super.getAvailableAction(); 
        action.add(new ArcaneBlastAction()); // add wizard special skill
        return action;
    }

    public void increaseAttackBonus(int value){
        arcaneBlastBonus += value; // when special skill used, +10 to wizard attack
    }

    public void resetLevelBonus(){
        arcaneBlastBonus = 0; // when game ends
    }

    public int getArcaneBlastBonus(){
        return arcaneBlastBonus; // getter for special skill
    }

}

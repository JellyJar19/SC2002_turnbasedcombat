import java.util.ArrayList;
import java.util.List;

import statusEffects.*;


public class Warrior extends Player {

    public Warrior(){
        super("Warrior", 260, 40, 20, 30);
        addStatusEffect();
    }

    public List<Actions> getAvailableActions() {
        List<Actions> action = super.getAvailableActions(); // waiting for the class to be made
        action.add((Actions) new ShieldBashAction()); // add warrior special skill
        return action;
    }

    private void addStatusEffect(){ //private because this does not need to be accessible outside
        statusEffects.add(new SmokeBombEffect());
    }

    public String getSpecialDesc() {
        return("Shield Bash Effect: Deal\r\n" + //
                        "BasicAttack damage to selected enemy.\r\n" + //
                        "Selected enemy is unable to take actions for\r\n" + //
                        "the current turn and the next turn.");
    }
}

import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public class Warrior extends Player {

    public Warrior(){
        super("Warrior", 260, 40, 20, 30);
    }

    public List<Action> getAvailableActions() {
        List<Action> action = super.getAvailableAction(); // waiting for the class to be made
        action.add(new ShieldBashAction()); // add warrior special skill
        return action;
    }

    public String getSpecialDesc() {
        return("Shield Bash Effect: Deal\r\n" + //
                        "BasicAttack damage to selected enemy.\r\n" + //
                        "Selected enemy is unable to take actions for\r\n" + //
                        "the current turn and the next turn.");
    }
}

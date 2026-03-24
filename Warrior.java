import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public class Warrior extends Player {
    public Warrior(String name){
        super(name, 260, 40, 20, 30);
    }

    public List<Action> getAvailableActions() {
        List<Action> action = super.getAvailableAction(); // waiting for the class to be made
        action.add(new ShieldBashAction()); // add warrior special skill
        return action;
    }
}

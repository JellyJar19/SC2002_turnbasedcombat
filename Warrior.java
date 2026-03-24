import java.util.ArrayList;
import java.util.List;

public class Warrior extends Player {
    public Warrior(String name){
        super(name, 260, 40, 20, 30);
    }

    public List<Action> getAvailableActions() {
        List<Action> action = super.getAvailableAction();
        action.add(new ShieldBashAction()); // add warrior special skill
        return action;
    }
}

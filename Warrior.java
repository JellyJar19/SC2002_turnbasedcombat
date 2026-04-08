import java.util.ArrayList;
import java.util.List;


public class Warrior extends Player {

    public Warrior(){
        super("Warrior", 260, 40, 20, 30);
    }

    public List<Actions> getAvailableActions() {
        List<Actions> action = super.getAvailableActions(); // waiting for the class to be made
        action.add((Actions) new ShieldBashAction()); // add warrior special skill
        return action;
    }

    @Override
    public void addStatusEffect(){
        super.addStatusEffect();
        statusEffects.add(new );
    }

    public String getSpecialDesc() {
        return("Shield Bash Effect: Deal\r\n" + //
                        "BasicAttack damage to selected enemy.\r\n" + //
                        "Selected enemy is unable to take actions for\r\n" + //
                        "the current turn and the next turn.");
    }
}

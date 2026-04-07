import java.util.ArrayList;
import java.util.List;

public class Wizard extends Player {
    private int arcaneBlastBonus;

    //wizard
    public Wizard(){
        super("Wizard", 200, 50, 10, 20);
        this.arcaneBlastBonus = 0;
    }

    public List<Actions> getAvailableActions(){
        // waiting for the class to be made
        List<Actions> action = super.getAvailableActions(); 
        action.add((Actions) new ArcaneBlastAction()); // add wizard special skill
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

    public String getSpecialDesc() {
        return("Arcane Blast Effect: Deal\r\n" + //
                        "BasicAttack damage to all enemies currently\r\n" + //
                        "in combat. Each enemy defeated by Arcane\r\n" + //
                        "Blast adds 10 to the Wizard’s Attack, lasting\r\n" + //
                        "until end of the level.");
    }

}

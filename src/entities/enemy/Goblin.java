package entities.enemy;
import java.util.List;

import entities.*;

public class Goblin extends Enemy {
    public Goblin(){
        super("Goblin", 55, 35, 15, 25, new BasicAttackOnlyStrategy());
        // waiting for the class to be made
    }

    public List<Actions> getAvailableActions() {
        System.out.print("not implemented yet");
        return(null);
        
    };
}
import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public abstract class Enemy extends Combatant {
    protected EnemyActionStrategy strategy; // waiting for the class to be made

    public Enemy(String name, int hp, int attack, int defense, int speed){
        super(name, hp, attack, defense, speed); //take from combatant;
        this.strategy = strategy;
    }

    public Action chooseAction(Battle battle){
        return strategy.chooseAction(this, battle); // pass enemy and battle state
    }

    public List<Action> getAvailableAction(){
        List<Action> action = new ArrayList<>();
        action.add(new BasicAttackAction()); // enemy only have basic attack
        return action;
    }
}

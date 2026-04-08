import java.util.ArrayList;
import java.util.List;

public abstract class Enemy extends Combatant {
    protected EnemyActionStrategy strategy; // waiting for the class to be made

    public Enemy(String name, int hp, int attack, int defense, int speed, EnemyActionStrategy strategy){
        super(name, hp, attack, defense, speed); //take from combatant;
        this.strategy = strategy;
    }

    public Actions chooseAction(Battle battle){
        return strategy.chooseAction(this, battle); // pass enemy and battle state
    }

    @Override
    public void addStatusEffect(){
        statusEffects.add(new StunEffect());
    }

    public List<Actions> getAvailableAction(){
        List<Actions> action = new ArrayList<>();
        action.add((Actions) new BasicAttackAction()); // enemy only have basic attack
        return action;
    }
}

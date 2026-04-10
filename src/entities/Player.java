import java.util.ArrayList;
import java.util.List;

import statusEffects.*;

public abstract class Player extends Combatant{
    //protected List<Item> inventory; //belongs to the battle class, not player

    public Player(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed); //take from combatant
        //this.inventory = new ArrayList<>();
        addStatusEffect();
    }
    
    // waiting for the class to be made
    /* 
    public List<Actions> getAvailableActions(){
        List<Actions> action = new ArrayList<>();
        action.add((Actions) new BasicAttackAction());
        action.add((Actions) new DefendAction());

        for (Item item:inventory){
            action.add((Actions) new UseItemAction(item));
        }
        return action; // avail action list is attack + defend + items avail
    }
    */
    private void addStatusEffect(){ //private because this does not need to be accessible outside
        statusEffects.add(new DefendBuff());
    }

    public List<Item> getInventory(){
        return inventory; // getter for inventory
    }

    public void addItem(Item item){
        inventory.add(item); // for player to add chosen item
    }

    public abstract String getSpecialDesc();

}

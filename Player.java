import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public abstract class Player extends Combatant{
    protected List<Item> inventory;

    public Player(String name, int hp, int attack, int defense, int speed) {
        super(name, hp, attack, defense, speed); //take from combatant
        this.inventory = new ArrayList<>();
    }
    
    // waiting for the class to be made
    public List<Action> getAvailableAction(){
        List<Action> action = new ArrayList<>();
        action.add(new BasicAttackAction());
        action.add(new DefendAction());

        for (Item item:inventory){
            action.add(new UseItemAction(item));
        }
        return action; // avail action list is attack + defend + items avail
    }

    public List<Item> getInventory(){
        return inventory; // getter for inventory
    }

    public void addItem(Item item){
        inventory.add(item); // for player to add chosen item
    }

}

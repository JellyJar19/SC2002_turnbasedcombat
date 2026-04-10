package actions;
import items.*;
import entities.*;
public class UseItemAction implements Actions{
    private Item item;

    UseItemAction(Item item){
        this.item = item;
    }
    
    @Override
    public void execute(Combatant activechar, Battle battle, Combatant target){
        item.use(activechar, battle, target);
    }
    
    public String getName(){return item.getName();}
    
}

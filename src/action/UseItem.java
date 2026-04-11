package action;
import items.*;
import entities.*;

public class UseItemAction extends AbstractActions{
    private Item item;

    UseItemAction(Item item){
        this.item = item;
    }
    
    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle){
        item.use(activechar, battle);
        // will need to relook at this w further discussion for the powerstone item - because taht requires specialskill. 
    }
    
    public String getName(){
      return "Use Item";
    }
    
}

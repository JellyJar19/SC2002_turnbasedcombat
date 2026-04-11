package action;
import items.*;
import entities.*;

public class UseItemAction implements Actions{
    private Item item;

    UseItemAction(Item item){
        this.item = item;
    }
    
    @Override
    public boolean execute(T activechar, T target, Battle battle){
        item.use(activechar, battle);
        // will need to relook at this w further discussion for the powerstone item - because taht requires specialskill. 
    }
    
    public String getName(){
      return "Use Item";
    }
    
}

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
        // need to check item implementation
    }
    
    public String getName(){
      return item.getName();
    }
    
}

package action;
import items.*;
import combatant.*;

public class UseItem extends AbstractActions{
    private Item item;

    UseItemAction(EffectStage e, Item item){
        super(e);
        this.item = item;
    }
    
    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle){
        return item.use(activechar, battle);
        // will need to relook at this w further discussion for the powerstone item - because taht requires specialskill. 
    }
    
    public String getName(){
      return "Use Item";
    }
    
}

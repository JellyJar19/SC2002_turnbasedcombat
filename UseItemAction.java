public class UseItemAction implements Action{
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

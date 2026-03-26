public abstract class Item {
    protected String name;

    public Item(String name){
        this.name = name;
    }

    public abstract void use(Player user, Battle battle, Combatant target);

    public String getName() {
        return name;
    }
    
}

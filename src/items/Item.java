package items;
import src.entities.Player;
import src.entities.Combatant;
import src.battleEngine.Battle;

public abstract class Item {
    private String name;

    public Item(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public abstract String getDescription(); //to be overriden by individual items

    public abstract void use(Player user, Battle battle, Combatant target);

    
}

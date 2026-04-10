package items;
import entities.*;

public class Potion extends Item {
    private int healAmount;

    public Potion(){
        super("Potion");
        this.healAmount = 100;
    }

    public void use(Player user, Battle battle, Combatant target){
        user.heal(healAmount);
    }

    public static String getItemDescStatic() {
        return("When used, Heal 100HP\r\n" + //
                        "New HP=min(Current HP+Heal Amount, Max HP)");
    }
}

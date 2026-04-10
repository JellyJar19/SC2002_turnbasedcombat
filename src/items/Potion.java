package items;
import src.battleEngine.Battle;
import src.entities.*;

public class Potion extends Item {
    private int healAmount;

    public Potion() {
        super("Potion");
        this.healAmount = 100;
    }

    public void use(Player user, Battle battle, Combatant target) {
        user.heal(this.healAmount);
    }

    public String getDescription() {
        return "When used, Heal 100HP. " +
               "New HP = min(Current HP + Heal Amount, Max HP)";
}
}
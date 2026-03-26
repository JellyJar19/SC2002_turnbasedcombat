public class Potion extends Item {
    private int healAmount;

    public Potion(){
        super("Potion");
        this.healAmount = 100;
    }

    public void use(Player user, Battle battle, Combatant target){
        user.heal(healAmount);
    }
}

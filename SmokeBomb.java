public class SmokeBomb extends Item {
    public SmokeBomb(){
        super("SmokeBomb");
    }

    public void use(Player user, Battle battle, Combatant target){
        user.addStatusEffect(StatusEffects.SmokeBombEffect);
    }
}

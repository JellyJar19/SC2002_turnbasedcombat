public class SmokeBomb extends Item {
    public SmokeBomb(){
        super("SmokeBomb");
    }

    public void use(Player user, Battle battle, Combatant target){
        user.addStatusEffect(StatusEffects.SmokeBombEffect);
    }

    public static String getItemDescStatic() {
        return("When used, Enemy attacks do 0 damage in the\r\n" + //
                        "current turn and the next turn");
    }
}

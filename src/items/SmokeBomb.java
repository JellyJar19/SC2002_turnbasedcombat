package items;

import src.entities.*;
import src.statusEffects.SmokeBombEffect;
import src.statusEffects.StatusEffects;
import src.battleEngine.Battle;

public class SmokeBomb extends Item {
    public SmokeBomb(){
        super("SmokeBomb");
    }

    public void use(Player user, Battle battle, Combatant target) {
        // Creates a new effect instance and cleanly applies it to the user
        user.addStatusEffect(new SmokeBombEffect());
    }

    public static String getItemDescStatic() {
        return("When used, Enemy attacks do 0 damage in the\r\n" + //
                        "current turn and the next turn");
    }
}

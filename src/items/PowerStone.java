package items;
import statusEffects.*;
import entities.*;
import entities.enemy.*;
import entities.player.*;

public class PowerStone extends Item {
    public PowerStone(){
        super("PowerStone");
    }

    public void use(Player user, Battle battle, Combatant target){
        int savedCooldown = user.getSkillCooldown();

        if (user instanceof Warrior){
            new ShieldBashAction().execute(user, battle, target);
        }
        else if (user instanceof Wizard){
            new ArcaneBlastAction().execute(user, battle, target);
        }

        user.setSkillCooldown(savedCooldown);
    }

    public static String getItemDescStatic() {
        return("Trigger the special skill effect once, but it does not\r\n" + //
                        "start or change the cooldown timer. In short, free\r\n" + //
                        "extra use of the skill.");
    }
    
}

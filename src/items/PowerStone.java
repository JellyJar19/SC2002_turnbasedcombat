package items;

import src.entities.*;
import src.actions.SpecialSkillAction;
import src.battleEngine.Battle;

public class PowerStone extends Item {
    public PowerStone(){
        super("PowerStone");
    }

    @Override
    public void use(Player user, Battle battle, Combatant target) {
        // 1. Save the current cooldown state
        int savedCooldown = user.getSkillCooldown();

        // 2. Fetch the specific player's skill polymorphically (No instanceof!)
        SpecialSkillAction skill = user.getSpecialSkill();
        
        // 3. Execute the skill
        skill.execute(user, battle, target);

        // 4. Restore the cooldown to fulfill the "Free Extra Use" requirement
        user.setSkillCooldown(savedCooldown);
    }

    @Override
    public String getDescription() {
        return "Trigger the special skill effect once, but it does not " +
               "start or change the cooldown timer. In short, free " +
               "extra use of the skill.";
    }
    
}

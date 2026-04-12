package action;
import combatant.*;
import statusEffects.*;


public class ShieldBash extends BasicAttack{

    public ShieldBash(){
    }

    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle){
        if (activechar.getSpecialCooldown() > 0){
            super.execute(activechar, target, battle);
            target.applyStatusEffect(this.effectStage.createEffect(Effects.STUNEFFECT));
            activechar.setSpecialCooldown(3);
            return true;
        } 
        else {
            return false;
        }

    }
    @Override
    public String getName(){return "ShieldBash";};
}
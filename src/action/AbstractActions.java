package action;
import combatant.*;

public abstract class AbstractAction implements Action {
    protected final EffectStage effectStage;

    public AbstractActions(EffectStage effectStage) {
        this.effectStage = effectStage;
    }

    public int calculateDamage(Combatant activechar, Combatant target){
        int atk = activechar.getTotalAttack(); // check combatant for base attack and buffs
        // need check how the buff attack calculation wld work. 
        int def = target.getTotalDefense(); // check combatant for base def and buffs
        if (target.getInvulnerability()){
            return 0;
        }
        else{
            return Math.max(0,atk - def);
        }
    }

}
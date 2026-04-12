package action;
import statusEffects.*;

public class StdEffectStage implements EffectStage{
    public StatusEffects createEffect(Effects e){
        switch(e){
            case STUNEFFECT:
                return new StunEffect();
            case ARCANEBUFF:
                return new ArcaneBuffEffect();
            case DEFENSEBUFF:
                return new DefenseBuffEffect();
            case INVULNERABILITYEFFECT:
                return new InvulnerabilityEffect();
            default:
                return null;
        }
    }
}

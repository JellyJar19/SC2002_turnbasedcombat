package action;
import statusEffects.*;
import entities.*;

public class Defend extends AbstractAction{
    public Defend(EffectStage e){
        super(e);
    }

    @Override
    public <T> boolean execute(T activechar, T target, BattleContext battle) {
        activechar.onApplyEffect(e.createEffect(DEFENSEBUFFEFFECT));
        return true;
    }
    @Override
    public string getName() {
        return "Defend";
    }
}

package action;
import statusEffects.*;
import entities.*;

public class Defend extends AbstractAction{
    public Defend(EffectStage e){
        super(e);
    }

    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle) {
        activechar.onApplyEffect(this.EffectStage.createEffect(Effects.DEFENSEBUFF));
        return true;
    }
    @Override
    public string getName() {
        return "Defend";
    }
}

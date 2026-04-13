package action;
import statusEffects.*;
import combatant.*;
import battleEngine.*;

public class Defend extends AbstractActions{
    public Defend(){
    }

    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle) {
        activechar.applyStatusEffect(this.effectStage.createEffect(Effects.DEFENSEBUFF));
        return true;
    }
    @Override
    public String getName() {
        return "Defend";
    }
}

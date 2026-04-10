package statusEffects;
import entities.*;

public class DefendBuff extends StatusEffects {

    @Override
    public void onApply(Combatant target) {
        this.active = true;
        this.duration = 2;
        target.defense += 10;
    }

    @Override
    public void startTurn(Combatant target) {
        if (this.active) {
            this.duration--;
        }
    }

    @Override
    public void endTurn(Combatant target) {
        if (this.duration == 0) {
            this.active = false;
            target.defense -= 10;
        }
    }
}

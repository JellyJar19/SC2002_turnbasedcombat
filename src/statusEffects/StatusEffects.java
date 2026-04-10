package statusEffects;
import entities.*;

public abstract class StatusEffects {

    int duration;
    boolean active;

    public abstract void onApply(Combatant target);
    public abstract void startTurn(Combatant target);
    public abstract void endTurn(Combatant target);

    public boolean isActive() {
        return active;
    }
}

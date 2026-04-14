package statusEffects;

import combatant.Combatant;

public class StunEffect extends StatusEffects {
    public StunEffect() {
        super(Effects.STUNEFFECT, 1);
    }

    @Override
    public void apply(Combatant target) {
        target.setStun(true);
    }

    @Override
    public void remove(Combatant target) {
        target.setStun(false);
    }
}
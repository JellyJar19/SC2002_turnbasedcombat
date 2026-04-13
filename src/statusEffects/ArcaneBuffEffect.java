package statusEffects;

import combatant.Combatant;

public class ArcaneBuffEffect extends StatusEffects {
    private final int attackBonus = 10;

    public ArcaneBuffEffect() {
        // Use a large number for "permanent" effects
        super(Effects.ARCANEBUFF, Integer.MAX_VALUE);
    }

    @Override
    public void apply(Combatant target) {
        target.setBaseAttack(target.getBaseAttack() + attackBonus);
    }

    @Override
    public void remove(Combatant target) {
        target.setBaseAttack(target.getBaseAttack() - attackBonus);
    }
}
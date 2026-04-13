package statusEffects;

import combatant.Combatant;

public class DefenseBuffEffect extends StatusEffects {
    private final int bonus = 10;

    public DefenseBuffEffect() {
        super(Effects.DEFENSEBUFF, 2);
    }

    @Override
    public void apply(Combatant target) {
        target.setBaseDefense(target.getBaseDefense() + bonus);
    }

    @Override
    public void remove(Combatant target) {
        target.setBaseDefense(target.getBaseDefense() - bonus);
    }
}
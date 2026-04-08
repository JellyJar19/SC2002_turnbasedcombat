public class ArcaneEffect extends StatusEffects {

    @Override
    public void onApply(Combatant target) {
        this.active = true;
        target.attack = target.getAttack() + 10;
    }

    @Override
    public void startTurn(Combatant target) {
        // no per-turn behaviour
    }

    @Override
    public void endTurn(Combatant target) {
        // no expiry logic — consider adding duration later
    }
}

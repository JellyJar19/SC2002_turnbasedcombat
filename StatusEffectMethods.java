public interface StatusEffectMethods {
    void onApply(Combatant target);
    void startTurn(Combatant target);
    void endTurn(Combatant target);
    boolean isActive();
}

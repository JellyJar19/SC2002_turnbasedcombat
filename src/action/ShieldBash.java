public class ShieldBash extends BasicAttack{

    public ShieldBash(EffectStage e){
        super(e);
    }

    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle){
        if (activechar.getSpecialCooldown() > 0){
            super.execute(activechar, target, battle);
            target.onApplyEffect(this.EffectStage.createEffect(Effects.STUNEFFECT));
            activechar.setSpecialCooldown();
            return true;
        } 
        else {
            return false;
        }

    }
    @Override
    public string getName(){return "ShieldBash";};
}
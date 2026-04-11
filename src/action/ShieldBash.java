public class ShieldBash extends BasicAttack{

    public ShieldBash(EffectStage e){
        super(e);
    }

    @Override
    public <T> boolean execute(T activechar, T target, Battle battle){
        if (activechar.getSpecialCooldown() > 0){
            super.execute(activechar, target, battle);
            activechar.onApplyEffect(e.createEffect(STUNEFFECT));
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
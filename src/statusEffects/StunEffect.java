package statusEffects;

public class StunEffect extends StatusEffects{

    public StunEffect(){
        super(Effects.STUNEFFECT,2);
    }

    @Override
    protected boolean setStun(){
        return !this.isExpired();
    }
}

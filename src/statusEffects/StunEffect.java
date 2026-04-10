package statusEffects;

public class StunEffect extends StatusEffects{

    public StunEffect(){
        super("StunEffect",2);
    }

    @Override
    protected boolean setStun(){
        if (isExpired())
            return false;
        return true;
    }
}

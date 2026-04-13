package statusEffects;

public class ArcaneBuffEffect extends StatusEffects {

    public ArcaneBuffEffect(){
        super(Effects.ARCANEBUFF, Double.POSITIVE_INFINITY);
    }

    @Override
    protected int getAttack(){ 
        return 10;
    }


}

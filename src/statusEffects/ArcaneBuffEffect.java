package statusEffects;

public class ArcaneBuffEffect extends StatusEffects {

    public ArcaneBuffEffect(){
        super(Effects.ARCANEBUFF,2);
    }

    @Override
    protected int getAttack(){ 
        return (this.isExpired())? 10:-10;
    }

    @Override 
    protected void tick(){
        return;
    }

}

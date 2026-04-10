package statusEffects;

public class ArcaneBuffEffect extends StatusEffects {

    public ArcaneBuffEffect(){
        super("ArcaneBuff",2);
    }

    @Override
    protected int getAttack(){ 
        if (this.isExpired()){
            return -10;
        }
        else {
            return 10;
        }
    }

}

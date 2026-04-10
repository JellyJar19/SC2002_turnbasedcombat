package statusEffects;

public class DefenseBuffEffect extends StatusEffects {

    public DefenseBuffEffect(){
        super("DefenseBuffEffect",2);
    }

    @Override
    protected int getDefense() {
        if (this.isExpired()){
            return -10;
        }
        return 10;
    }
}

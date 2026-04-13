package statusEffects;

public class DefenseBuffEffect extends StatusEffects {

    public DefenseBuffEffect(){
        super(Effects.DEFENSEBUFF,2);
    }

    @Override
    protected int getDefense() {
        return 10;
    }
}

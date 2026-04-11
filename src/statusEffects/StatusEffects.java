package statusEffects;

public abstract class StatusEffects {
    private Effects type;
    private int duration;
    
    public StatusEffects(Effects type,int duration){
        this.type = type;
        this.duration = duration;
    }

    public Effects getType(){
        return type;
    }

    protected void tick(){
        if (duration>0)
            duration--;
    }

    protected boolean isExpired(){
        return this.duration<=0;
    }

    protected int getDefense(){
        return 0;
    }

    protected int getAttack(){
        return 0;
    }

    protected boolean setStun(){
        return false;
    } 

    protected boolean setInvulnerability(){
        return false;
    }
}

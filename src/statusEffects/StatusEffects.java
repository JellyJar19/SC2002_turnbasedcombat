package statusEffects;

public abstract class StatusEffects {
    private String name;
    private int duration;
    
    public StatusEffects(String name,int duration){
        this.name = name;
        this.duration = duration;
    }

    protected boolean isExpired(){
        return this.duration==0;
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

public enum StatusEffects {
    SmokeBombEffect(){
        public void onApply(Combatant target){
        this.active=true;
        this.duration = 2;
    }

    public void startTurn(Combatant target){ 
        this.duration--;
    }

    public void endTurn(Combatant target){
        if (this.duration==0){
            this.active=false;
        }
    }
    },
    DefendBuff(){
    public void onApply(Combatant target){
        this.active=true;
        this.duration=2;
    }

    public void startTurn(Combatant target){
        this.duration--;

    }

    public void endTurn(Combatant target){
        if (this.duration==0){
            this.active=false;
        }
    }
    },
    StunEffect(){
        public void onApply(Combatant target){
            this.active=true;
            this.duration=2;
            target.setStun(true);
    }

    public void startTurn(Combatant target){
        this.duration--;

    }

    public void endTurn(Combatant target){
        if (this.duration==0){
            target.setStun(false);
            this.active=false;
        }
    }
    }; 

    int duration;
    boolean active; //validity of status effect

    private StatusEffects(){
        this.active=false; //only become active when onApply is called
    }

    abstract public void onApply(Combatant target); //to be called when action is acted on Characters

    abstract public void startTurn(Combatant target); //to be called at the start of each turn (if action is applied)

    abstract public void endTurn(Combatant target); //to be called at the end of each turn

    public boolean isActive(){
        return active;
    }

}

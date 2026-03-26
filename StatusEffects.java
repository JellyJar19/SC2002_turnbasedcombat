public enum StatusEffects {
    SmokeBombEffect(2){
        public void onApply(Combatant target){
        //apply action onto target
        this.active=true;
        this.duration = 2;
    }

    public void startTurn(Combatant target){
        //actions to take during start of turn
        this.duration--;
    }

    public void endTurn(Combatant target){
        //actions to take during end of turn
        if (this.duration==0){
            this.active=false;
        }
    }
    },
    DefendBuff(2){
        public void onApply(Combatant target){
        this.active=true;
    }

    public void startTurn(Combatant target){
        //actions to take during start of turn
        this.duration--;

    }

    public void endTurn(Combatant target){
        //actions to take during end of turn
        if (this.duration==0){
            this.active=false;
        }
    }
    },
    StunEffect(2){
        public void onApply(Combatant target){
            this.active=true;
            target.setStun(true);
    }

    public void startTurn(Combatant target){
        //actions to take during start of turn

    }

    public void endTurn(Combatant target){
        //actions to take during end of turn
        if (this.duration==0){
            target.setStun(false);
            this.active=false;
        }
    }
    }; 

    int duration;
    boolean active; //validity of status effect

    private StatusEffects(int dur){
        this.duration=dur;
        this.active=false; //only become active when onApply is called
    }

    abstract public void onApply(Combatant target);

    abstract public void startTurn(Combatant target);

    abstract public void endTurn(Combatant target);

    public boolean isActive(){
        return active;
    }

}

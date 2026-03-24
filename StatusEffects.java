public enum StatusEffects {
    SmokeBombEffect(2){
        public void onApply(Combatant target){
        //apply action onto target
    }

    public void startTurn(Combatant target){
        //actions to take during start of turn

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
        ////apply action onto target
    }

    public void startTurn(Combatant target){
        //actions to take during start of turn

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
        ////apply action onto target
    }

    public void startTurn(Combatant target){
        //actions to take during start of turn

    }

    public void endTurn(Combatant target){
        //actions to take during end of turn
        if (this.duration==0){
            this.active=false;
        }
    }
    }; 

    int duration;
    boolean active; //validity of status effect

    private StatusEffects(int dur){
        this.duration=dur;
        this.active=true;
    }

    abstract public void onApply(Combatant target);

    abstract public void startTurn(Combatant target);

    abstract public void endTurn(Combatant target);

    public boolean isActive(){
        return active;
    }

}

public enum StatusEffects {
    SmokeBombEffect(){
        
        public void onApply(Combatant target){
            this.active=true;
            this.duration = 2;
        }

        public void startTurn(Combatant target){  
            if (this.active){
                this.duration--;
            }
        }

        public void endTurn(Combatant target){
            if (this.duration==0){
                this.active=false;
                this.duration=2;
            }
        }

    },
    DefendBuff(){
        /*
        store original defense status of combatant, so that it can revert back to original values if less
        then 10 defense points were used during the round
        */
        private int OGDefense=0; 
        public void onApply(Combatant target){
            this.active=true;
            this.duration=2;
        }

        public void startTurn(Combatant target){
            if (this.active){
                this.OGDefense=target.getDefense(); //store the original defense values
                target.defense+=10;//add 10 defense values for the start of the round
                this.duration--;
            }
        }

        public void endTurn(Combatant target){
            target.defense=this.OGDefense;
            //else target.defense should be left at the score it is with
            this.OGDefense=0; //reset values
            if (this.duration==0){
                this.active=false;
                this.duration=2;
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
            if (this.active){
                this.duration--;
            }
        }

        public void endTurn(Combatant target){
            if (this.duration==0){
                target.setStun(false);
                this.active=false;
                this.duration=2;
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

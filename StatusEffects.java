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
            }
        }

    },
    DefendBuff(){
        /*
        store original defense status of combatant, so that it can revert back to original values if less
        then 10 defense points were used during the round
        */
        public void onApply(Combatant target){
            this.active=true;
            target.defense+=10;
            this.duration=2;
        }

        public void startTurn(Combatant target){
            if (this.active){
                this.duration--;
            }
        }

        public void endTurn(Combatant target){
            if (this.duration==0){
                this.active=false;
                target.defense-=10;
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
            }
        }
    },
    ArcaneEffect(){

        public void onApply(Combatant target){
            this.active=true;
            target.attack=target.getAttack()+10;
        }

        public void startTurn(Combatant target){  
            return;
        }

        public void endTurn(Combatant target){
            return;
        }
    };
    
    

    int duration;
    boolean active; //validity of status effect


    abstract public void onApply(Combatant target); //to be called when action is acted on Characters

    abstract public void startTurn(Combatant target); //to be called at the start of each turn (if action is applied)

    abstract public void endTurn(Combatant target); //to be called at the end of each turn

    public boolean isActive(){
        return active;
    }

}

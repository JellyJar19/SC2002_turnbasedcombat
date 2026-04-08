import java.util.ArrayList;
import java.util.List;


public abstract class Combatant {

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attack;
    protected int defense;
    protected int speed;
    protected boolean stun; //decides whether combatant is able to make actions for that round
    protected ArrayList<StatusEffects> statusEffects; //store the status effects that can be applied, program will check if it is active or not  
    protected int skillCooldown;

    // constructor
    public Combatant(String name, int hp, int attack, int defense, int speed) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.stun=false;
        this.statusEffects = new ArrayList<StatusEffects>();
        this.statusEffects.add(StatusEffects.StunEffect);
        this.skillCooldown = 0;
    }

    public void takeDamage(int amount) {
        if (this.hp - amount < 0) {
            this.hp = 0;
        } 
        else {
            this.hp = this.hp - amount;
        }
    }
    public void heal(int amount) {
        if (this.hp + amount > this.maxHp) {
            this.hp = this.maxHp;
        } 
        else {
            this.hp = this.hp + amount;
        }
    }

    public abstract void addStatusEffect();

    // this one need see how keane does it
    public void applyStatusEffects() { //iterate through the list and minus off the status effects
        
    }

    // this one need see how keane does it
    //no need to remove expired effects, just need to activate or deactive them
    /* 
    public void removeExpiredEffects() {
        //this.status=null;
    }
    */

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean canAct() {
        return !this.stun;
    }

    public void reduceCooldown() {
        if (skillCooldown > 0) {
            skillCooldown--;
        }
    }

    public abstract List<Actions> getAvailableActions();
    
    // getters in case we need
    public String getName() { 
        return name; 
    }

    public int getHp() { 
        return hp; 
    }

    public int getMaxHp() { 
        return maxHp; 
    }

    public int getAttack() { 
        return attack; 
    }

    public int getDefense() { 
        return defense; 
    }

    public int getSpeed() { 
        return speed; 
    }

    public int getSkillCooldown() { 
        return skillCooldown; 
    }

    public void setStun(boolean stun){
        this.stun=stun;
    }

    //setter method

}

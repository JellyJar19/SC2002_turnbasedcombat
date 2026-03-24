import java.util.ArrayList;
import java.util.List;

import javax.swing.Action;

public abstract class Combatant {

    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attack;
    protected int defense;
    protected int speed;
    protected boolean freeze; //decides whether combatant is able to make actions for that round
    //protected List<StatusEffects> statusEffects; 
    protected StatusEffects status;
    protected int skillCooldown;

    // constructor
    public Combatant(String name, int hp, int attack, int defense, int speed) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.freeze=false;
        this.status = null;
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

    // this one need see how keane does it
    public void addStatusEffect(StatusEffects effect) {
        //statusEffects.add(effect);
        effect.onApply(this);
    }

    // this one need see how keane does it
    public void applyStatusEffects() { //iterate through the list and minus off the status effects
        for (StatusEffect effect : statusEffects) {
            effect.onTurnStart(this);
        }
    }

    // this one need see how keane does it
    //cannot remove statusEffect elements from list while iterating
    public void removeExpiredEffects() {
        /* 
        for (StatusEffect effect : statusEffects) {
            if (!effect.isActive()){

            }
            effect.decreaseDuration();
        }
        statusEffects.removeIf(StatusEffect::isExpired);
        */
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    // this one need see how keane does it
    public boolean canAct() {
        return this.freeze;
    }

    public void reduceCooldown() {
        if (skillCooldown > 0) {
            skillCooldown--;
        }
    }

    public abstract List<Action> getAvailableActions();
    
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

    public void setFreeze(boolean freeze){
        this.freeze=freeze;
    }
    /* 
    public List<StatusEffect> getStatusEffects() { 
        return statusEffects; 
    }
    */

}

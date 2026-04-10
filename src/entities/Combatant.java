package entities;

import java.util.ArrayList;
import java.util.List;
import statusEffects.StatusEffects;

public abstract class Combatant {
    protected String name;
    protected int hp;
    protected int maxHp;
    protected int attack;
    protected int defense;
    protected int speed;
    protected boolean stun; 
    protected ArrayList<StatusEffects> statusEffects; 
    protected int skillCooldown;

    //constructor
    public Combatant(String name, int hp, int attack, int defense, int speed) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.stun = false;
        this.statusEffects = new ArrayList<>();
        this.skillCooldown = 0;
    }


    //methods
    public void takeDamage(int amount) {
        if (amount < 0) {
            amount = 0;
        }

        this.hp -= amount;

        if (this.hp < 0) {
            this.hp = 0;
        }
    }

    public void heal(int amount) {
        if (amount < 0) {
            amount = 0;
        }

        this.hp += amount;

        if (this.hp > this.maxHp) {
            this.hp = this.maxHp;
        }
    }

    public boolean isAlive() {
        return this.hp > 0;
    }

    public boolean canAct() {
        return this.isAlive() && !this.stun;
    }

    public void reduceCooldown() {
        if (this.skillCooldown > 0) {
            this.skillCooldown--;
        }
    }



    //status effects related
    public void addStatusEffect(StatusEffects effect) {
        if (effect != null) {
            this.statusEffects.add(effect);
        }
    }

    public void removeStatusEffect(StatusEffects effect) {
        if (effect != null) {
            this.statusEffects.remove(effect);
        }
    }

    public void clearStatusEffects() {
        this.statusEffects.clear();
    }

    public List<StatusEffects> getStatusEffects() {
        return this.statusEffects;
    }

    //getters
    public String getName() {
        return this.name;
    }

    public int getHp() {
        return this.hp;
    }

    public int getMaxHp() {
        return this.maxHp;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean isStunned() {
        return this.stun;
    }

    public int getSkillCooldown() {
        return this.skillCooldown;
    }

    public abstract List getAvailableActions();
   
    //setters
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }

    public void setHp(int hp) {
        if (hp < 0) {
            this.hp = 0;
        } else if (hp > this.maxHp) {
            this.hp = this.maxHp;
        } else {
            this.hp = hp;
        }
    }

    public void setMaxHp(int maxHp) {
        if (maxHp > 0) {
            this.maxHp = maxHp;

            // keep current hp valid after max hp changes
            if (this.hp > this.maxHp) {
                this.hp = this.maxHp;
            }
        }
    }

    public void setAttack(int attack) {
        if (attack >= 0) {
            this.attack = attack;
        }
    }

    public void setDefense(int defense) {
        if (defense >= 0) {
            this.defense = defense;
        }
    }

    public void setSpeed(int speed) {
        if (speed >= 0) {
            this.speed = speed;
        }
    }

    public void setStun(boolean stun) {
        this.stun = stun;
    }

    public void setStatusEffects(ArrayList<StatusEffects> statusEffects) {
        if (statusEffects == null) {
            this.statusEffects = new ArrayList<>();
        } else {
            this.statusEffects = statusEffects;
        }
    }

    public void setSkillCooldown(int skillCooldown) {
        if (skillCooldown < 0) {
            this.skillCooldown = 0;
        } else {
            this.skillCooldown = skillCooldown;
        }
    }

}

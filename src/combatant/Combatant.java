package src.combatant;

import java.lang.annotation.Target;
import java.util.List;

import src.items.Item;
import statusEffects.StatusEffects;

public class Combatant {
    private String name;
    private int hp;
    private int maxHp;
    private int baseAttack;
    private int baseDefense;
    private int speed;
    private int specialCooldown;
    private List<StatusEffects> activeEffects;
    private List<Item> inventory;

    public void takeDamage(int damageAmmount) {
        if (this.hp - damageAmmount < 0) {
            this.hp = 0;
        } else {
            this.hp = this.hp - damageAmmount;
        }
    }

    public void heal(int healAmount) {
        if (this.hp <= 0) {
            throw new IllegalAccessException("Dead entities shouldn't be healed!!!");
        }
        if (this.hp + healAmount > maxHp) {
            this.hp = maxHp;
        } else {
            this.hp = this.hp + healAmount;
        }
    }

    public boolean isAlive() {
        if (this.hp == 0) {
            return false;
        } else {
            return true;
        }
    }

    public void addStatusEffect(StatusEffects appliedEffect) {
        activeEffects.add(appliedEffect);
    }
}

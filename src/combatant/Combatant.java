package src.combatant;

import java.lang.annotation.Target;
import java.util.List;

import src.items.Item;
import src.statusEffects.StatusEffects;
import src.action.*;

public abstract class Combatant {
    private String name;
    private int hp;
    private int maxHp;
    private int baseAttack;
    private int baseDefense;
    private int speed;
    private int specialCooldown;
    private List<StatusEffects> activeEffects;
    private List<Item> inventory;

    public Combatant(String name, int maxHp, int baseAttack, int baseDefense, int speed) {
        this.name = name;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.speed = speed;
        this.inventory = inventory;
    }

    public void takeDamage(int damageAmmount) {
        if (this.hp - damageAmmount < 0) {
            this.hp = 0;
        } else {
            this.hp = this.hp - damageAmmount;
        }
    }

    public void heal(int healAmount) {
        if (this.hp <= 0) {
            System.out.println("Cannot heal a defeated combatant.");
            return;
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

    public abstract Action getSpecialSkill();

    public void addStatusEffect(StatusEffects effect) {
        this.activeEffects.add(effect);
    }

    public void decreaseCooldown() {
        if (this.specialCooldown > 0) {
            this.specialCooldown = this.specialCooldown - 1;
        }
    }

    public abstract void performTurn(BattleContext context);



}

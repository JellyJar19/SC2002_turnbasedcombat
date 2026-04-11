package combatant;

import java.lang.annotation.Target;
import java.util.List;

import items.*;
import statusEffects.*;
import action.*;

public abstract class Combatant {
    private String name;
    private int hp;
    private int maxHp;
    private int baseAttack;
    private int baseDefense;
    private int speed;
    private int specialCooldown;
    private boolean stun;
    private boolean invulnerable;
    private List<StatusEffects> activeEffects;
    private List<Item> inventory;
<<<<<<< HEAD
    private List<Action> availableActions;
    private IEffectManager effectManager;
=======
    private EffectManager effectManager;
>>>>>>> 808ef168924d9b00f8b7bbee7deaf7235c958345

    public Combatant(String name, int maxHp, int baseAttack, int baseDefense, int speed) {
        this.name = name;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
        this.speed = speed;
        this.inventory = new List<Item>();
        this.effectManager = new EffectManager();
        this.availableActions = availableActions;
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

    //public void addStatusEffect(StatusEffects effect) {
    //    this.activeEffects.add(effect);
    // } CHOOSE TOP OR BOTTOM 
    // public void addStatusEffect(StatusEffects effect){
    //     this.activeEffects.applyEffect(this.activeEffects, effect);
    // }

    public void decreaseCooldown() {
        if (this.specialCooldown > 0) {
            this.specialCooldown = this.specialCooldown - 1;
        }
    }

    public abstract void performTurn(BattleContext context);

    //setters and getters

    // ── name ──────────────────────────────────────────────
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // ── hp ────────────────────────────────────────────────
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = Math.max(0, Math.min(hp, this.maxHp)); // clamp between 0 and maxHp
    }

    // ── maxHp ─────────────────────────────────────────────
    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    // ── baseAttack ────────────────────────────────────────
    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    // ── baseDefense ───────────────────────────────────────
    public int getBaseDefense() {
        return baseDefense;
    }

    public void setBaseDefense(int baseDefense) {
        this.baseDefense = baseDefense;
    }

    // ── speed ─────────────────────────────────────────────
    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    // ── specialCooldown ───────────────────────────────────
    public int getSpecialCooldown() {
        return specialCooldown;
    }

    public void setSpecialCooldown(int specialCooldown) {
        this.specialCooldown = Math.max(0, specialCooldown); // cooldown can't go below 0
    }

    // ── activeEffects ─────────────────────────────────────
    public List<StatusEffects> getActiveEffects() {
        return activeEffects;
    }

    public void setActiveEffects(List<StatusEffects> activeEffects) {
        this.activeEffects = activeEffects;
    }

    // ── inventory ─────────────────────────────────────────
    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
    // ── invulnerable ─────────────────────────────────────────
    public boolean getInvulnerability(){
        return invulnerable;
    }
    public void setInvulnerability(boolean boo){
        this.invulnerable=boo;
    }
    // ── stun ─────────────────────────────────────────
    public boolean getStun(){
        return stun;
    }
    public void setStun(boolean boo){
        this.stun=boo;
    }


    //combatant logic

    //items

    //actions
    public List<Action> getAvailableActions(){
        return availableActions;
    }

    public void setDefaultActions(){
        BasicAttack ba = new BasicAttack();
        Defend df = new Defend();
        UseItem ui = new UseItem();
        this.availableActions = Arrays.asList(ba, df, ui);
    }

    public void setAvailableActions(List<Action> availableActions){
        this.availableActions = availableActions;
    }

    public void addAvailableActions(Action act){
        this.availableActions.add(act);
    }

    //status effect
    public void onApplyEffect(ArcaneBuffEffect e){ //called when first applied
        this.baseAttack+=effectManager.applyEffect(activeEffects, e);
    }

    public void onApplyEffect(DefenseBuffEffect e){ //called when first applied
        this.baseDefense+=effectManager.applyEffect(activeEffects, e);
    }

    public void onApplyEffect(StunEffect e){ //called when first applied
        this.stun=effectManager.applyEffect(activeEffects, e);
    }

    public void onApplyEffect(InvulnerabilityEffect e){ //called when first applied
        this.invulnerable=effectManager.applyEffect(activeEffects, e);
    }

    public void onEndTurn(){ //called on end of combatant turn to remove all statusEffects that are expired
        effectManager.tickEffects(activeEffects, this); 
    }


}

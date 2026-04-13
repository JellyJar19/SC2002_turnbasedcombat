package statusEffects;

import combatant.Combatant;

public abstract class StatusEffects {
    protected Effects type;
    protected int duration; // Changed to int for easier ticking; use Integer.MAX_VALUE for infinity

    public StatusEffects(Effects type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public Effects getType() {
        return type;
    }

    // This method is called by the manager every turn
    public void tick() {
        if (duration > 0 && duration != Integer.MAX_VALUE) {
            duration--;
        }
    }

    public boolean isExpired() {
        return duration <= 0;
    }

    // MANDATORY METHODS for all subclasses
    // Each effect will define exactly what it changes on the combatant
    public abstract void apply(Combatant target);
    public abstract void remove(Combatant target);
    
    // Helper for UI/Console output
    public int getDuration() {
        return duration;
    }
}
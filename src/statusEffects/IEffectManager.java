package statusEffects;
import java.util.List;
import combatant.*;

/**
 * Controller interface for managing status effects on a single combatant.
 * Works with a List<StatusEffect> provided by the caller.
 */
public interface IEffectManager {

    
    //Applies a new status effect to the combatant's active effects list.
    
    public int applyEffect(List<StatusEffects> activeEffects, ArcaneBuffEffect effect);
    public int applyEffect(List<StatusEffects> activeEffects, DefenseBuffEffect effect);
    public boolean applyEffect(List<StatusEffects> activeEffects, StunEffect effect);
    public boolean applyEffect(List<StatusEffects> activeEffects, InvulnerabilityEffect effect);

    
    //Advances turn for all effects: ticks duration, removes expired ones.
    //Should be called at the start of the combatant's turn.
     
    public void tickEffects(List<StatusEffects> activeEffects, Combatant combatant);

    
    //Sums attack modifiers from all active effects.
     
    public int getTotalAttackModifier(List<StatusEffects> activeEffects);

    
    //Sums defense modifiers from all active effects.

    public int getTotalDefenseModifier(List<StatusEffects> activeEffects);

    /*
     * Checks if any effect prevents the combatant from acting.
     */
    public boolean isActionPrevented(List<StatusEffects> activeEffects);

    
    //Checks if any effect negates incoming damage.
    
    public boolean isDamageNegated(List<StatusEffects> activeEffects);

    
    //Removes all active effects.
    
    public void clearEffects(List<StatusEffects> activeEffects);

    
    //Returns a formatted list of effect names with remaining turns (for UI).
    
    public List<String> getEffectDescriptions(List<StatusEffects> activeEffects);
}



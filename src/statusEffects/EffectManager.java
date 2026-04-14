package statusEffects;

import java.util.*;
import combatant.Combatant;

public class EffectManager {

    public void applyEffect(List<StatusEffects> activeEffects, StatusEffects newEffect, Combatant target) {
        // Handle uniqueness for ARCANEBUFF
        if (newEffect.getType() == Effects.ARCANEBUFF) {
            for (StatusEffects s : activeEffects) {
                if (s.getType() == Effects.ARCANEBUFF) return; 
            }
        }
        activeEffects.add(newEffect);
        newEffect.apply(target);
    }

    public void tickEffects(List<StatusEffects> activeEffects, Combatant combatant) {
        Iterator<StatusEffects> iterator = activeEffects.iterator();
        while (iterator.hasNext()) {
            StatusEffects effect = iterator.next();
            effect.tick(); 
            if (effect.isExpired()) {
                effect.remove(combatant); // This reverses the buff/stun/etc.
                iterator.remove();
            }
        }
    }

    // Called when the battle ends to wipe all buffs/debuffs
    public void clearEffects(List<StatusEffects> activeEffects, Combatant combatant) {
        for (StatusEffects effect : activeEffects) {
            effect.remove(combatant);
        }
        activeEffects.clear();
    }

    public List<String> getEffectDescriptions(List<StatusEffects> activeEffects) {
        List<String> descriptions = new ArrayList<>();
        for (StatusEffects effect : activeEffects) {
            String dur = (effect.getDuration() == Integer.MAX_VALUE) ? "Perm" : effect.getDuration() + "t";
            descriptions.add(effect.getType() + " [" + dur + "]");
        }
        return descriptions;
    }
}
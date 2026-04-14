package statusEffects;

import java.util.*;
import combatant.Combatant;

public class EffectManager {

<<<<<<< HEAD
    //to be called when applying a status effect

    public int applyEffect(List<StatusEffects> activeEffects, ArcaneBuffEffect e) { //can only add 1 of such status effects
        boolean check = activeEffects.stream()
                                     .noneMatch(s->s.getType() == Effects.ARCANEBUFF);
        if (check){
            activeEffects.add(e);
        }
        return e.getAttack();
    }

    public int applyEffect(List<StatusEffects> activeEffects, DefenseBuffEffect e) { //option to add multiple
        activeEffects.add(e);
        return e.getDefense();
    }

    public boolean applyEffect(List<StatusEffects> activeEffects, StunEffect e) { //option to add multiple
        activeEffects.add(e);
        return e.setStun();
    }

    public boolean applyEffect(List<StatusEffects> activeEffects, InvulnerabilityEffect e) { //option to add multiple
        activeEffects.add(e);
        return e.setInvulnerability();
    }

    //to be called each turn
    public void tickEffects(List<StatusEffects> activeEffects,Combatant combatant) {
        //tick all effects if not null
        if (activeEffects!=null){
            for (StatusEffects effect : activeEffects) {
                effect.tick();
            }
            //collect expired items to list
            List<StatusEffects> res = activeEffects.stream()
                        .filter(s->s.isExpired())
                        .collect(Collectors.toList());

            //
            for (StatusEffects status : res){
                Effects check = status.getType();
                switch(check){
                    case Effects.ARCANEBUFF -> {
                        combatant.setBaseAttack(combatant.getBaseAttack()+status.getAttack()); //will return -10 if exipired
                    }
                    case Effects.DEFENSEBUFF -> {
                        combatant.setBaseDefense(combatant.getBaseDefense()+status.getDefense());
                    }
                    case Effects.INVULNERABILITYEFFECT -> {
                        combatant.setInvulnerability(status.setInvulnerability()); //will return false if expired
                    }
                    case Effects.STUNEFFECT -> {
                        combatant.setStun(status.setStun());
                    }
                }
            }

            activeEffects.removeAll(res);
        }
=======
    public void applyEffect(List<StatusEffects> activeEffects, StatusEffects newEffect, Combatant target) {
        // Handle uniqueness for ARCANEBUFF
        if (newEffect.getType() == Effects.ARCANEBUFF) {
            for (StatusEffects s : activeEffects) {
                if (s.getType() == Effects.ARCANEBUFF) return; 
            }
        }
        activeEffects.add(newEffect);
        newEffect.apply(target);
>>>>>>> 0a4ce93fcc427b90ac1564625fb87e0d27365731
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
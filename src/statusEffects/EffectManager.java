package statusEffects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import combatant.*;

public class EffectManager implements IEffectManager{


    //to be called when applying a status effect
    @Override
    public int applyEffect(List<StatusEffects> activeEffects, ArcaneBuffEffect e) {
        activeEffects.add(e);
        return e.getAttack();
    }
    @Override
    public int applyEffect(List<StatusEffects> activeEffects, DefenseBuffEffect e) {
        activeEffects.add(e);
        return e.getAttack();
    }
    @Override
    public boolean applyEffect(List<StatusEffects> activeEffects, StunEffect e) {
        activeEffects.add(e);
        return e.setStun();
    }
    @Override
    public boolean applyEffect(List<StatusEffects> activeEffects, InvulnerabilityEffect e) {
        activeEffects.add(e);
        return e.setInvulnerability();
    }

    //to be called each turn
    @Override
    public void tickEffects(List<StatusEffects> activeEffects,Combatant combatant) {
        for (StatusEffects effect : activeEffects) {
            effect.tick();
        }
        List<StatusEffects> res = activeEffects.stream()
                     .filter(s->s.isExpired())
                     .collect(Collectors.toList());

        for (StatusEffects status : res){
            Effects check = status.getType();
            switch(check){
                case Effects.ARCANEBUFF -> {
                    combatant.setBaseAttack(combatant.getBaseAttack()+status.getAttack());
                }
                case Effects.DEFENSEBUFF -> {
                    combatant.setBaseAttack(combatant.getBaseDefense()+status.getDefense());
                }
                case Effects.INVULNERABILITYEFFECT -> {
                    combatant.setInvulnerability(status.setInvulnerability());
                }
                case Effects.STUNEFFECT -> {
                    combatant.setStun(status.setStun());
                }
            }
        }
    }

    @Override
    public int getTotalAttackModifier(List<StatusEffects> activeEffects) {
        int total = 0;
        for (StatusEffects effect : activeEffects) {
            total += effect.getAttackModifier();
        }
        return total;
    }

    @Override
    public int getTotalDefenseModifier(List<StatusEffects> activeEffects) {
        int total = 0;
        for (StatusEffects effect : activeEffects) {
            total += effect.getDefenseModifier();
        }
        return total;
    }

    @Override
    public boolean isActionPrevented(List<StatusEffects> activeEffects) {
        for (StatusEffects effect : activeEffects) {
            if (effect.preventsAction()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isDamageNegated(List<StatusEffects> activeEffects) {
        for (StatusEffects effect : activeEffects) {
            if (effect.negatesDamage()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clearEffects(List<StatusEffects> activeEffects) {
        activeEffects.clear();
    }

    @Override
    public List<String> getEffectDescriptions(List<StatusEffects> activeEffects) {
        List<String> descriptions = new ArrayList<>();
        for (StatusEffects effect : activeEffects) {
            descriptions.add(effect.getName() + " (" + effect.getRemainingTurns() + " turns)");
        }
        return descriptions;
    }
}

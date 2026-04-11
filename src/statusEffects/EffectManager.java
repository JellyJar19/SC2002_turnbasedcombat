package statusEffects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import combatant.*;

public class EffectManager implements IEffectManager{


    //to be called when applying a status effect
    @Override
    public int applyEffect(List<StatusEffects> activeEffects, ArcaneBuffEffect e) { //can only add 1 of such status effects
        boolean check = activeEffects.stream()
                                     .noneMatch(s->s.getType() == Effects.ARCANEBUFF);
        if (check){
            activeEffects.add(e);
        }
        return e.getAttack();
    }
    @Override
    public int applyEffect(List<StatusEffects> activeEffects, DefenseBuffEffect e) { //option to add multiple
        activeEffects.add(e);
        return e.getDefense();
    }
    @Override
    public boolean applyEffect(List<StatusEffects> activeEffects, StunEffect e) { //option to add multiple
        activeEffects.add(e);
        return e.setStun();
    }
    @Override
    public boolean applyEffect(List<StatusEffects> activeEffects, InvulnerabilityEffect e) { //option to add multiple
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
                    combatant.setBaseAttack(combatant.getBaseAttack()+status.getAttack()); //will return -10 if exipired
                }
                case Effects.DEFENSEBUFF -> {
                    combatant.setBaseAttack(combatant.getBaseDefense()+status.getDefense());
                }
                case Effects.INVULNERABILITYEFFECT -> {
                    combatant.setInvulnerability(status.setInvulnerability()); //will return false if expired
                }
                case Effects.STUNEFFECT -> {
                    combatant.setStun(status.setStun());
                }
            }
        }
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

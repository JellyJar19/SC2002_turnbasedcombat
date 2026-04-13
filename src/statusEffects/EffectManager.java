package statusEffects;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import combatant.*;

public class EffectManager{


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
        //tick all effects
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
                case ARCANEBUFF -> {
                    combatant.setBaseAttack(combatant.getBaseAttack()+status.getAttack()); //will return -10 if exipired
                }
                case DEFENSEBUFF -> {
                    combatant.setBaseDefense(combatant.getBaseDefense()+status.getDefense());
                }
                case INVULNERABILITYEFFECT -> {
                    combatant.setInvulnerability(status.setInvulnerability()); //will return false if expired
                }
                case STUNEFFECT -> {
                    combatant.setStun(status.setStun());
                }
            }
        }

        activeEffects.removeAll(res);
    }


    public void clearEffects(List<StatusEffects> activeEffects) {
        activeEffects.clear();
    }

    public List<String> getEffectDescriptions(List<StatusEffects> activeEffects) {
        List<String> descriptions = new ArrayList<>();
        for (StatusEffects effect : activeEffects) {
            descriptions.add(effect.getType() + " (" + effect.duration + " turns)");
        }
        return descriptions;
    }
}

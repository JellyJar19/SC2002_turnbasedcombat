package statusEffects;
import statusEffects.*;


public class HandleEffects {
    //apply function 
    public static int onApply(ArcaneBuffEffect e){
        return e.getAttack();
    }

    public static int onApply(DefenseBuffEffect e){
        return e.getDefense();
    }

    public static boolean onApply(StunEffect e){
        return e.setStun();
    }

    public static boolean onApply(InvulnerabilityEffect e){
        return e.setInvulnerability();
    }

    //on remove 
    public static int onRemove(ArcaneBuffEffect e){
        return e.getAttack();
    }

    public static int onRemove(DefenseBuffEffect e){
        return e.getDefense();
    }

    public static boolean onRemove(StunEffect e){
        return e.setStun();
    }

    public static boolean onRemove(InvulnerabilityEffect e){
        return e.setInvulnerability();
    }
}

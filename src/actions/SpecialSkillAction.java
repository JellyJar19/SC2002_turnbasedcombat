package actions;
import items.*;
import entities.*;
import battleEngine.*;
public abstract class SpecialSkillAction implements Actions{

    public  void execute(Combatant activechar, Battle battle, Combatant target){};
    public boolean isOffCooldown(Combatant activechar){
        if (activechar.skillCooldown > 0){
            return false;
        }
        else return true;
    };
    public String getName(){return "";}
}

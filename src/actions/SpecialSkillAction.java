public abstract class SpecialSkillAction implements Action{
    public void execute(Combatant activechar, Battle battle, Combatant target){};
    public boolean isOffCooldown(Combatant activechar){
        if (activechar.skillcooldown > 0){
            return false;
        }
        else return true;
    };
    public String getName(){return "";}
}

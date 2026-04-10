import statusEffects.*;

public class ShieldBashAction extends SpecialSkillAction{
    @Override
    public void execute(Combatant activechar, Battle battle, Combatant target){
        if (activechar instanceof Warrior){
            Warrior activechar = (Warrior) activechar;
            if (this.isOffCooldown(activechar)){
                System.out.println(activechar.getName() + " used " + this.getName() + " on " + target.getName());
                BasicAttackAction BasicAttack = new BasicAttackAction();
                BasicAttack.execute(activechar, battle, target); // deal basic attack damage to target
                statusEffects targetStun = new StunEffect;
                targetStun.onApply(target);
            }
            else{
                System.out.println("Shield Bash on Cooldown " + x + " turns remaining. ");
            }
        }
    }
    @Override
    public String getName(){
        return "Shield Bash";
    }
}

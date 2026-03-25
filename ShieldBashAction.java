public class ShieldBashAction extends SpecialSkillAction{
    @Override
    public void execute(Combatant activechar, Battle battle, Combatant target){
        if (activechar instanceof Warrior){
            Warrior activechar = (Warrior) activechar;
            if (this.isOffCooldown(activechar)){
                BasicAttackAction BasicAttack = new BasicAttackAction();
                BasicAttack.execute(activechar, battle, target); // deal basic attack damage to target
                target.addStatusEffect(StunEffect);
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

public class ArcaneBlastAction extends SpecialSkillAction{
    @Override
    public void execute(Combatant activechar, Battle battle, Combatant[] target){
        if (activechar instanceof Wizard){
            if (this.isOffCooldown(activechar)){
                for (int i = 0; i < target.size(); i++){
                    if (!target[i].isAlive()){
                        continue; // skip over enemies that are already dead
                    } else {
                        BasicAttackAction BasicAttack = new BasicAttackAction();
                        BasicAttack.execute(activechar, battle, target[i]);
                        if (!target[i].isAlive()) {
                            activechar.increaseAttackBonus(10);
                        } // each kill adds 10 to attack given by arcane blast bonus. 
                    }
                }
            }
            else {
                System.out.println("Arcane Blast on Cooldown " + x + " turns remaining. ");
                return;
            }
        }
    }
    @Override
    public String getName(){
        return "Arcane Blast";
    }
    
}
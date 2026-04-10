public class ArcaneBlast extends BasicAttack implements Action{
    @Override
    public <T> boolean execute(T activechar, T[] target, Battle battle){
        // loop through all the targets
        if (activechar.getSpecialCooldown() > 0){
            for (int i = 0; i < target.size(); i++){
                if (!target[i].isAlive()){
                    continue; // skip over enemies that are already dead
                } else {
                    super.execute(activechar, target[i], battle);
                    if (!target[i].isAlive()) {
                        activechar.increaseAttackBonus();
                    } // each kill adds 10 to attack given by arcane blast bonus. 
                }
            }
            return true;
        }
        else {
            return false;
        }
    };
    @Override
    public string getName(){return "Arcane Blast";}
}
// arcane blast still has many issues. 
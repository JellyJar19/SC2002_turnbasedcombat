package action;
import statusEffects.*;
import entities.*;

public class ArcaneBlast extends BasicAttack implements Action{
    @Override
    public <T> boolean execute(T activechar, T target, Battle battle){
        // loop through all the targets
        if (activechar.getSpecialCooldown() > 0){
            int ABE = 0;
            for (Combatant enemy : battle.getAllEnemies()){
                if (!enemy.isAlive()){
                    continue; // skip over enemies that are already dead
                } else {
                    super.execute(activechar, enemy, battle);
                    if (!enemy.isAlive()) {
                        ABE += 1;
                    } // each kill adds 10 to attack given by arcane blast bonus. 
                }
            }
            statusEffect buff = new ArcaneBlastEffect(ABE);
            activechar.setStatusEffect(buff);
            activechar.setSpecialCooldown(); // set special cooldown
            return true; // I still need to figure out how the status effects work. 
        }
        else {
            return false;
        }
    };
    @Override
    public string getName(){return "Arcane Blast";}
}
// arcane blast still has many issues. 
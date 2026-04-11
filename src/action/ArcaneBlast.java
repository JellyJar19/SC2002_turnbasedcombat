package action;
import statusEffects.*;
import entities.*;

public class ArcaneBlast extends BasicAttack{
    public ArcaneBlast(EffectStage e){
        super(e);
    }
    
    @Override
    public <T> boolean execute(T activechar, T target, BattleContext battle){
        // loop through all the targets
        if (activechar.getSpecialCooldown() > 0){
            for (Combatant enemy : battle.getAllEnemies()){
                if (!enemy.isAlive()){
                    continue; // skip over enemies that are already dead or invulnerable
                } else {
                    super.execute(activechar, enemy, battle);
                    if (!enemy.isAlive()) {
                       activechar.onApplyEffect(e.createEffect(ARCANEBUFFEFFECT));
                    } // each kill adds 10 to attack given by arcane blast bonus. 
                }
            }
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

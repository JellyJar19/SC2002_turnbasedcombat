package action;
import statusEffects.*;
import combatant.*;

public class ArcaneBlast extends BasicAttack{
    public ArcaneBlast(EffectStage e){
    }
    
    @Override
    public <T extends Combatant> boolean execute(T activechar, T target, BattleContext battle){
        // loop through all the targets
        if (activechar.getSpecialCooldown() > 0){
            for (Combatant enemy : battle.getAllEnemies()){
                if (!enemy.isAlive() && enemy.getInvulnerability()){ //added condition for .getInvulnerability
                    continue; // skip over enemies that are already dead or invulnerable
                } else {
                    super.execute(activechar, enemy, battle);
                    if (!enemy.isAlive()) {
                       activechar.applyStatusEffect(this.effectStage.createEffect(Effects.ARCANEBUFF));
                    } // each kill adds 10 to attack given by arcane blast bonus. 
                }
            }
            activechar.setSpecialCooldown(3); // set special cooldown
            return true; 
        }
        else {
            return false;
        }
    };
    @Override
    public String getName(){return "Arcane Blast";}
}

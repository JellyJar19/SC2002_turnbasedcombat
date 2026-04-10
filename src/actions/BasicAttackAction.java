package actions;

public class BasicAttackAction implements Actions {
    public void execute(Combatant activechar, Battle battle, Combatant target){
        int atk = activechar.getAttack();
        int def = target.getDefense();
        int dmg = Math.max(0,atk - def);
        target.takeDamage(dmg);
        // debating if i need to end turn there. 
    };

    public String getName() {return "Basic Attack";}
}

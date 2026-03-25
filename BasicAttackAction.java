public class BasicAttackAction implements Action {
    public void execute(Combatant activechar, Battle battle, Combatant target){
        int atk = activechar.getAttack();
        int def = target.getDef();
        int dmg = Math.Max(0,atk - def);
        target.takeDamage(dmg);
        // debating if i need to end turn there. 
    };
    public String getName() {return "Basic Attack";}
}

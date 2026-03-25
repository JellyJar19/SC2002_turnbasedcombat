public class DefendAction implements Action{
    @Override
    public void execute(Combatant activechar, Battle battle){
        int def = activechar.getDef();
        activechar.addStatusEffect(DefendBuff()); //increase def for 2 turns 
    }
    @Override
    public String getName(){return "Defend";}
}

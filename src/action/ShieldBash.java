public class ShieldBash extends BasicAttack implements Action{
    @Override
    public <T> boolean execute(T activechar, T target, Battle battle){
        if (activechar.getSpecialCooldown() > 0){
            super.execute(activechar, target, battle);
            // insert stun effect logic here
            return true;
        } 
        else {
            return false;
        }
        

    }
    @Override
    public string getName(){return "ShieldBash";};
}
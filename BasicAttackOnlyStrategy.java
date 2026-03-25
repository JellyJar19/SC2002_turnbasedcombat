public class BasicAttackOnlyStrategy {
    public void chooseAction(Combatant activechar, Battle battle, Combatant[] targetList){
        for (int i = 0; i < enemylist.length(); i++){
            while (targetList[i].isAlive()){
                BasicAttackAction basicAttack = new BasicAttackAction();
                basicAttack.execute(activechar, battle, targetList[i]);
            }
        }
    }
    public String getStrategy(){return "Basic Attack Only. ";}

}

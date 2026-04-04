
public class Battle {
    private Combatant[] currentEnemies = new Combatant[ConstantsClass.MAXENEMIES];
    private Combatant currentAllies;
    private Item[] currentItems = new Item[2];
    private Combatant[] turnOrder = new Combatant[ConstantsClass.TOTALCOMBATANTS];
    private int roundNumber;
    private Level currentLevel;



    Battle(Player playerChar, Item[] playerItems, Level difficultyLevel) {
        currentAllies = playerChar;
        difficultyLevel.spawnEnemies(currentEnemies);
        currentItems = playerItems;
        roundNumber = 1;
        currentLevel = difficultyLevel;
        Battle_Engine.TurnOrderStrategy(turnOrder, currentAllies, currentEnemies);

    }

    
    public void rounds(){

        boolean continueGame=true;
        
        while(continueGame){
            this.printRoundStatus();
            Battle_Engine.processRounds(this); //processRounds returns true or false
        }

    }


    public void printRoundStatus() {
        System.out.print("Round " + roundNumber + ": ");
        System.out.print("Enemies: \n");
        for (int i = 0; i < ConstantsClass.MAXENEMIES; i++) {
            if ((currentEnemies[i] != null)) {
                System.out.println(currentEnemies[i].getName());
                System.out.println("HP : " + currentEnemies[i].getHp());
                if (currentEnemies[i].getHp() <= 0) {
                    System.out.print("[DEAD]");
                } else {
                    System.out.println("Atk : " + currentEnemies[i].getAttack());
                    System.out.println("Def : " + currentEnemies[i].getDefense());

                    // print active debuffs????

                }
            }
            System.out.println();
        }

        System.out.print("Player: \n");
        System.out.println(currentAllies.getName());
        System.out.println("HP : " + currentAllies.getHp());
        System.out.println("Def : " + currentAllies.getDefense());
        
        // print active debuffs ????
    }

    public Item[] getCurrentItems() {
        return(currentItems);
    }

    public Combatant[] getEnemies() {
        return(currentEnemies);
    }

    public Combatant getCurrentAllies() {
        return(currentAllies);
    }

    public Combatant[] getTurnOrder() {
        return(turnOrder);
    }

    public Level getLevel() {
        return(currentLevel);
    }
    public boolean isPlayerDefeated() {
        if (currentAllies.getHp() <= 0) {
            return(true);
        } else {
            return(false);
        }
    }

    public boolean allEnemiesDefeated() {
        for (int i = 0; i < ConstantsClass.MAXENEMIES; i++) {
            if (currentEnemies[i].getHp() > 0) {
                return(false);
            }
        }
        return(true);
    }

}
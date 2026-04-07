public abstract class Battle_Engine{

    public static Battle StartBattle(Player playerChar, Item[] playerItems, Level difficultyLevel) {
        return(new Battle(playerChar, playerItems, difficultyLevel));


    }

    public static boolean processRounds(Battle currentBattle) {
        
        Combatant turnOrder[] = currentBattle.getTurnOrder();
        for (Combatant combatant : turnOrder){
            //iterate through the combatant 
            
        }

        
       /* 
        for (int i = 0; i < ConstantsClass.TOTALCOMBATANTS; i++) {
            //each combatant gets an action

            continue;
            
        }
         */
        return endRound(currentBattle);
        
    }


    //roundOrder is passed by reference, will update it
    public static void TurnOrderStrategy(Combatant[] roundOrder, Combatant currentAllies, Combatant[] currentEnemies) {
        //fill in roundOrder array
        for (int i = 0; i < ConstantsClass.MAXENEMIES; i++) {
            roundOrder[i] = currentEnemies[i];
        }
        roundOrder[ConstantsClass.TOTALCOMBATANTS - 1] = currentAllies;


        // bubble sort
        int swapped;
        Combatant temp;
        for (int i = 0; i < ConstantsClass.MAXENEMIES; i++) {
            swapped = 0;
            for (int j = 0; j < (ConstantsClass.MAXENEMIES - i); j++) {
                if ((roundOrder[j+1] == null) || (roundOrder[j] == null) || (roundOrder[j].getSpeed() < roundOrder[j+1].getSpeed())) {
                    temp = roundOrder[j];
                    roundOrder[j] = roundOrder[j+1];
                    roundOrder[j+1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0) {
                break;
            }
        }

        for (int i = 0; i < ConstantsClass.TOTALCOMBATANTS; i ++) {
            if (roundOrder[i] != null) {
                System.out.println();
                System.out.println("!!!!remove later? !!!");
                System.out.print("Turn of orders : " + roundOrder[i].getName() + " " + roundOrder[i].getSpeed() + ", ");
            }
        }

    }
        

    private static boolean endRound(Battle CurrentBattle) {
        if (CurrentBattle.isPlayerDefeated() == true) {

            // Player loss
            return false;
        } else if (CurrentBattle.allEnemiesDefeated() == true) {
            if (CurrentBattle.getLevel().getBackupStatus() > 0) {
                CurrentBattle.getLevel().spawnBackupEnemies(CurrentBattle.getEnemies());
                return true;
            } else {
                
                //Player win


                return false;
            }
        } else {
            
            // continue game
            return true;
        }

    }
} 


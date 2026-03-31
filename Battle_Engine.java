public abstract class Battle_Engine{

    public static Battle StartBattle(Player playerChar, Item[] playerItems, Level difficultyLevel) {
        return(new Battle(playerChar, playerItems, difficultyLevel));


    }

    public static void processRounds(Battle currentBattle) {
        currentBattle.printRoundStatus();

        for (int i = 0; i < ConstantsClass.TOTALCOMBATANTS; i++) {
            //each combatant gets an action
            continue;
            
        }

        
    }


        public static void TurnOrderStrategy(Combatant[] roundOrder, Combatant currentAllies, Combatant[] currentEnemies) {
            //fill in roundOrder array
            for (int i = 0; i < ConstantsClass.MAXENEMIES; i++) {
                roundOrder[i] = currentEnemies[i];
            }
            roundOrder[ConstantsClass.TOTALCOMBATANTS] = currentAllies;


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
                    System.out.print(roundOrder[i].getName() + " " + roundOrder[i].getSpeed());
                }
            }

        }
        
        
}

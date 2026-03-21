public abstract class Battle_Engine extends UserInterface{

        public static void StartBattle(Playable playerChar, Item[] playerItems, Level difficultyLevel) {
            Battle CurrentBattle = new Battle(playerChar, playerItems, difficultyLevel);

        }

        public static void TurnOrderStrategy(Entity[] roundOrder, Entity currentAllies, Entity[] currentEnemies) {
            //fill in roundOrder array
            for (int i = 0; i < 5; i++) {
                roundOrder[i] = currentEnemies[i];
            }
            roundOrder[5] = currentAllies;


            // bubble sort
            int swapped;
            Entity temp;
            for (int i = 0; i < 5; i++) {
                swapped = 0;
                for (int j = 0; j < (5 - i); j++) {
                    if (roundOrder[j].getSpd() > roundOrder[j+1].getSpd()) {
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

        }
        
        
}

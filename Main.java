


public class Main {


    public static void main(String[] args) {
        Player playerChar = new Warrior(); //Player character is initially set to warrior, but player can change characters
        Item[] playerItems = new Item[ConstantsClass.MAXITEMS]   ;   //Array of 2 Items, which can be selected by the player.
        Level difficultyLevel = new Level(1);
        

        Battle currentBattle = MainMenu.printInterface(playerChar, playerItems, difficultyLevel);  // Pass playerChar and playerItems as references so changes can be made to them in menu.
        //loop to this until while loop becomes false
        while(Battle_Engine.processRounds(currentBattle)){
            System.out.println("test!");
        }
    
        //ending screen

    }
}

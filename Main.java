


public class Main {

    public static void main(String[] args) {
        Playable[] playerChar = new Playable[1]; // So the reason this is an array of length 1 is cuz it lets me pass by reference
        playerChar[0] = new Warrior();     //Player character is initially set to warrior, but player can change characters
        Item[] playerItems = new Item[2];         //Array of 2 Items, which can be selected by the player.
        Level[] difficultyLevel = new Level[1];
        difficultyLevel[0] = new Level(1);

        MainMenu.printInterface(playerChar, playerItems, difficultyLevel);  // Pass playerChar and playerItems as references so changes can be made to them in menu.
        Battle_Engine.StartBattle(playerChar, playerItems, difficultyLevel);
        //ending screen

    }
}

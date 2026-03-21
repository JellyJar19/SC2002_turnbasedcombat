import java.util.Scanner;

public abstract class MainMenu extends UserInterface {
    static Scanner sc = new Scanner(System.in);    
    public static void printInterface(Playable playerChar, Item[] playerItems) {
           
        int choice;


        //List current player details

        System.out.print("- GAME START -\n\n");

        while (true) {
        System.out.print("Current Character: " + playerChar.getName() +"\n\n");
        System.out.print("Player Attributes:\n" +
        "HP:" + playerChar.getHP() +
        "\nAtk:" + playerChar.getAttack() +
        "\nDef:" + playerChar. getDef() +
        "\nSpd:" + playerChar.getSpd() + "\n\n" +
        playerChar.getSpecialDesc() + "\n");
        

        //List options player can do

        System.out.print("1. Change Characters\n");
        System.out.print("2. Select Items\n");

        System.out.print("Current Difficulty: \n");
        System.out.print("3. Change Difficulty\n");
        System.out.print("4. List Difficulty Details\n");
        System.out.print("5. List Enemy Details\n");
        System.out.print( "6. Start Battle\n");


        // Ask player to select an option

        System.out.print("Please select an option: \n");
        choice = sc.nextInt();
        while ((choice < 1) || (choice > 6)) {
            System.out.println("Invalid Input. Please enter a number between 1 and 6.\n");
            choice = sc.nextInt();
        }
        switch(choice) {
            case 1: {
                playerChar = changeCharacters();
                break;
            }
            case 2: {
                selectItems(playerItems);
                break;
            }
            case 3: {

                break;
            }
            case 4: {

                break;
            }
            case 5: {

                break;
            }
            case 6: {
                sc.close();
                return;
            }
        }
    }
    
    
    }

    private static Playable changeCharacters() {

    //Asks user to select a character and returns an entity of the type the user selected

        int choice;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\n\n\n\nSelect a character:\n");
        System.out.print("1. Warrior\n");
        System.out.print("2. Wizard\n");
        choice = sc.nextInt();
        while((choice < 1) || (choice > 2)) {
            System.out.print("Invalid input, please enter 1 or 2.\n");
            choice = sc.nextInt();
        }
        switch(choice) {
            case 1: {
                Playable playerChar = new Warrior();
                return(playerChar);
            }
            default: {
                Playable playerChar = new Wizard();
                return(playerChar);
            }
        }
    }


    private static void selectItems(Item[] playerItems) {
        int choice;
        Scanner sc = new Scanner(System.in);
        

        //list item details

        System.out.print("1. Potion\n");
        System.out.print(Potion.getItemDesc() + "\n");
        System.out.print("2. Power Stone\n");
        System.out.print(PowerStone.getItemDesc() + "\n");
        System.out.print("3. Smoke Bomb\n");
        System.out.print(SmokeBomb.getItemDesc() + "\n");


        //User selects item
        
        System.out.print("You may select 2 items:\n");
        for (int i = 0; i < 2;i++) {
            System.out.print("Select item " + Integer.toString(i + 1));
            choice = sc.nextInt();
            while((choice < 1) || (choice > 3)) {
                System.out.print("Invalid input, please enter a number between 1 and 3.\n");
                choice = sc.nextInt();
            }
        switch(choice) {
            case 1: {
                playerItems[i] = new Potion();
                break;
            }
            case 2: {
                playerItems[i] = new PowerStone();
                break;
            }
            default: {
                playerItems[i] = new SmokeBomb();
                break;
            }
        }
    }
        System.out.print("You have selected [" + playerItems[0].getName() + "] and [" + playerItems[1].getName() + "]\n");
        return;
    
    }

    


}

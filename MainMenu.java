import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MainMenu extends UserInterface {
    static Scanner sc = new Scanner(System.in);    
    public static Battle printInterface(Player playerChar, Item[] playerItems, Level difficultyLevel) {
           
        int choice;


        //List current player details

        System.out.print("- GAME START -\n\n");

        while (true) {
        System.out.print("\n\nCurrent Character: " + playerChar.getName() +"\n\n");
        System.out.print("Player Attributes:\n" +
        "HP:" + playerChar.getHp() +
        "\nAtk:" + playerChar.getAttack() +
        "\nDef:" + playerChar. getDefense() +
        "\nSpd:" + playerChar.getSpeed() + "\n\n" +
        playerChar.getSpecialDesc() + "\n\n");
        

        //List options player can do

        System.out.print("1. Change Characters\n");
        System.out.print("2. Select Items\n");

        System.out.print("Current Difficulty: " + difficultyLevel.getLevel() + "\n");
        System.out.print("3. Change Difficulty\n");
        System.out.print("4. List Difficulty Details\n");
        System.out.print("5. List Enemy Details\n");
        System.out.print( "6. Start Battle\n");


        // Ask player to select an option

        System.out.print("Please select an option: \n");

        while(true){
            try{
                choice = sc.nextInt();
                if (choice>=1 && choice<=6)
                    break;
                else
                    System.out.println("Enter a number between 1 and 6 only!");
            }
            catch(InputMismatchException e){
                sc.next(); //clear the error line
                System.out.println("Enter integers only!");
            }
        }

        /* 
        choice = sc.nextInt();
        while ((choice < 1) || (choice > 6)) {
            System.out.println("Invalid Input. Please enter a number between 1 and 6.\n");
            choice = sc.nextInt();
        }
        */
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
                changeDifficulty(difficultyLevel);
                break;
            }
            case 4: {

                break;
            }
            case 5: {

                break;
            }
            case 6: {
                return(Battle_Engine.StartBattle(playerChar, playerItems, difficultyLevel));
            }
        }
    }
    
    
    }

    private static Player changeCharacters() {

    //Asks user to select a character and returns an entity of the type the user selected

        int choice;
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
                Player playerChar = new Warrior();
                return(playerChar);
            }
            default: {
                Player playerChar = new Wizard();
                return(playerChar);
            }
        }
    }


    private static void selectItems(Item[] playerItems) {
        int choice;
        
        //list item details

        System.out.print("1. Potion\n");
        System.out.print(Potion.getItemDescStatic() + "\n");
        System.out.print("2. Power Stone\n");
        System.out.print(PowerStone.getItemDescStatic() + "\n");
        System.out.print("3. Smoke Bomb\n");
        System.out.print(SmokeBomb.getItemDescStatic() + "\n");


        //User selects item
        
        System.out.print("You may select " + ConstantsClass.MAXITEMS +  " items:\n");
        for (int i = 0; i < ConstantsClass.MAXITEMS;i++) {
            System.out.print("Select item " + Integer.toString(i + 1) + ": ");
            choice = sc.nextInt();
            while(true){
            try{
                choice = sc.nextInt();
                if (choice>=1 && choice<=2)
                    break;
                else
                    System.out.println("Enter a number between 1 and 2 only!");
            }
            catch(InputMismatchException e){
                sc.next(); //clear the error line
                System.out.println("Enter integers only!");
            }
        }
            /* 
            while((choice < 1) || (choice > 3)) {
                System.out.print("Invalid input, please enter a number between 1 and 3.\n");
                choice = sc.nextInt();
            }
            */
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
        System.out.print("You have selected");
        for (int i = 0; i < ConstantsClass.MAXITEMS; i++) {
            System.out.print(" [" + playerItems[i].getName() + "]");
        }
        return;
    
    }

    private static void changeDifficulty(Level difficultyLevel) {
        int choice;

        System.out.print("Select a difficulty: \n");
        System.out.print("1. EASY\n");
        System.out.print("2. MEDIUM\n");
        System.out.print("3. HARD\n");
        choice = sc.nextInt();

        while((choice < 1) || (choice > 3)) {
            System.out.print("Invalid input, please enter a number between 1 and 3.\n");
            choice = sc.nextInt();
        }

        difficultyLevel.setDifficulty(choice);
        return;
        }

    }




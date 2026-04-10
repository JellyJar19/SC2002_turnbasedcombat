import java.util.InputMismatchException;
import java.util.Scanner;

import src.battleEngine.Battle;
import src.battleEngine.Battle_Engine;
import src.constClass.ConstantsClass;
import src.entities.Combatant;
import src.entities.Player;
import src.entities.enemy.Goblin;
import src.entities.enemy.Wolf;
import src.entities.player.Warrior;
import src.entities.player.Wizard;
import src.items.Item;
import src.items.Potion;
import src.items.PowerStone;
import src.items.SmokeBomb;
import src.level.*;

public abstract class MainMenu extends UserInterface {
    private static Scanner sc = new Scanner(System.in);    
    private static Player playerChar;
    private static Item[] playerItems;
    private static Level difficultyLevel;
    public static Battle printInterface(Player playerCharInput, Item[] playerItemsInput, Level difficultyLevelInput) {
           
        int choice;
        playerChar = playerCharInput;
        playerItems = playerItemsInput;
        difficultyLevel = difficultyLevelInput;
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
                changeCharacters();
                break;
            }
            case 2: {
                selectItems();
                break;
            }
            case 3: {
                changeDifficulty(difficultyLevel);
                break;
            }
            case 4: {
                showDifficultyDetails();
                break;
            }
            case 5: {
                showEnemyDetails();
                break;
            }
            case 6: {
                if (playerItems[0] == null) {
                    System.out.println("\nYou have not selected your items yet. Please select your items!\n");
                    break;
                }
                return(Battle_Engine.StartBattle(playerChar, playerItems, difficultyLevel));
            }
        }
    }
    
    
    }

    private static void changeCharacters() {

    //Asks user to select a character and returns an entity of the type the user selected

        int choice;
        System.out.println("\n\n\n\n\nSelect a character:\n");
        System.out.print("1. Warrior\n");
        System.out.print("2. Wizard\n");
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
        choice = sc.nextInt();
        while((choice < 1) || (choice > 2)) {
            System.out.print("Invalid input, please enter 1 or 2.\n");
            choice = sc.nextInt();
        }
        */
        switch(choice) {
            case 1: {
                playerChar = new Warrior();
            }
            default: {
                playerChar = new Wizard();
            }
        }
    }


    private static void selectItems() {
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
            while(true){
            try{
                choice = sc.nextInt();
                if (choice>=1 && choice<=3)
                    break;
                else
                    System.out.println("Enter a number between 1 and 3 only!");
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

    private static void changeDifficulty(Level currentLevel) {
        int choice;

        System.out.print("Select a difficulty: \n");
        System.out.print("1. EASY\n");
        System.out.print("2. MEDIUM\n");
        System.out.print("3. HARD\n");
        while(true){
            try{
                choice = sc.nextInt();
                if (choice>=1 && choice<=3)
                    break;
                else
                    System.out.println("Enter a number between 1 and 3 only!");
            }
            catch(InputMismatchException e){
                sc.next(); //clear the error line
                System.out.println("Enter integers only!");
            }
        }

        switch(choice) {
    case 1: 
        currentLevel = new Level(new EasyDifficulty());
        break;
    case 2: 
        currentLevel = new Level(new MediumDifficulty());
        break;
    case 3: 
        currentLevel = new Level(new HardDifficulty());
        break;
} 
        }

    

    private static void showDifficultyDetails() {
        System.out.println("Easy:");
        System.out.println("Wave 1: 3 Goblins\n");
        System.out.println("Medium:");
        System.out.println("Wave 1: 1 Goblin, 1 Wolf");
        System.out.println("Wave 2: 2 Wolves\n");
        System.out.println("Hard:");
        System.out.println("Wave 1: 2 Goblins");
        System.out.println("Wave 2: 1 Goblin, 2 Wolves");
    }

    private static void showEnemyDetails() {
        Combatant tempEnemy = new Goblin();
        System.out.println("Goblin: ");
        System.out.println("Hp: " + tempEnemy.getHp());
        System.out.println("Attack: " + tempEnemy.getAttack());
        System.out.println("Defense: " + tempEnemy.getDefense());
        System.out.println("Speed: " + tempEnemy.getSpeed() + "\n");
        tempEnemy = new Wolf();
        System.out.println("Wolf: ");
        System.out.println("Hp: " + tempEnemy.getHp());
        System.out.println("Attack: " + tempEnemy.getAttack());
        System.out.println("Defense: " + tempEnemy.getDefense());
        System.out.println("Speed: " + tempEnemy.getSpeed() + "\n");
        
    }

}

import java.util.Scanner;

public abstract class MainMenu extends UserInterface {
    public static void printInterface() {
        Scanner sc = new Scanner(System.in);
        Entity PlayerChar = new Warrior();
        int choice;
        System.out.println("- GAME START -\n\n");
        System.out.println("Current Character: " + PlayerChar.getName() +"\n\n");
        System.out.println("Player Attributes:\n" +
        "HP:" + PlayerChar.getHP() +
        "\nAtk:" + PlayerChar.getAttack() +
        "\nDef:" + PlayerChar. getDef() +
        "\nSpd:" + PlayerChar.getSpd() + "\n\n");
        System.out.println("1. Change Characters\n");
        System.out.println("2. Select Items\n");

        System.out.println("Current Difficulty: ");
        System.out.println("3. Change Difficulty");
        System.out.println("4. List Difficulty Details");
        System.out.println("5. List Enemy Details");

        System.out.println("Please select an option: \n")
        choice = sc.nextInt();
        while ((choice < 1) & (choice > 5)) {
            System.out.println("Invalid Input. Please enter a number between 1 and 5.");
            choice = sc.nextInt();
        }
}

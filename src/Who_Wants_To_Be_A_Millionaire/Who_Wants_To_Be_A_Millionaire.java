package Who_Wants_To_Be_A_Millionaire;

import UserInterface.HardOption;
import UserInterface.EasyOption;
import UserInterface.DisplayExceptionMessage;
import UserInterface.Display;
import Database.Player;
import Exceptions.MillionaireExceptions;
import static java.lang.System.exit;
import java.util.Scanner;

public class Who_Wants_To_Be_A_Millionaire {

    public static void main(String[] args) throws MillionaireExceptions {
        viewMainMenu();
    }
    
    private static void viewMainMenu() {
        Scanner read = new Scanner(System.in);
        Display display = new Display();
        DisplayExceptionMessage displayExMessage = new DisplayExceptionMessage();
        
        String menuOption="";
        String backMenu="";
        
        display.mainMenu();
        try {
            menuOption = read.nextLine();
            displayExMessage.returnChoice(menuOption);
        }
        catch(MillionaireExceptions ex) {
            System.out.println("\nError : " + ex.getMessage());
            exit(0);
        }
        String name="";
        switch(menuOption.toUpperCase().charAt(0)) {
            case 'S':
                do {
                    System.out.print("\nEnter your name: ");
                    name = read.nextLine();
                } while(name.length()==0);
                Player player = new Player(name);
                System.out.println("\nWelcome " + player.getPlayerName().toUpperCase() + "! Lets begin the game!");
                viewDifficultyOption();
                break;
            case 'V':
                display.viewRules();
                do {
                    System.out.print("\nEnter 'M' to go back to Main Menu: ");
                    backMenu = read.nextLine();
                } while(!backMenu.equalsIgnoreCase("M"));
                viewMainMenu();
                break;      
            case 'X':
                System.out.println("\nExit. Bye!\n");
                exit(0);
                break;    
            default: 
                System.out.println("\nYou have entered an incorrect option. Please try again.\n");
                break;
        }
    }
    
    private static void viewDifficultyOption() {
        Scanner read = new Scanner(System.in);
        
        Display display = new Display();
        DisplayExceptionMessage displayExMessage = new DisplayExceptionMessage();
        EasyOption easy = new EasyOption();
        HardOption hard = new HardOption();
        
        display.difficultyOptions();
        String difficultyOption = "";
        
        try {
            difficultyOption = read.nextLine();
            displayExMessage.returnChoice(difficultyOption);
        }
        catch(MillionaireExceptions ex) {
            System.out.println("\nError : " + ex.getMessage());
            exit(0);
        }
        
        switch(difficultyOption.toUpperCase().charAt(0)) {
            case 'E':
                System.out.println("\nEasy Difficulty Option\n");
                easy.start();
                break;
            case 'H':
                System.out.println("\nHard Difficulty Option\n");
                hard.start();
                break;
            case 'X':
                System.out.println("\nExit. Bye!\n");
                exit(0);
                break;
            default:
                System.out.println("\nYou have entered an incorrect option. Please try again.\n");
                break;
        }
    }
}

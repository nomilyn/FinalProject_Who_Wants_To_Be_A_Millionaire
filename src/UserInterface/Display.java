package UserInterface;

public class Display {
    public void mainMenu() {
        System.out.println("------------------------------");
        System.out.println("WHO WANTS TO BE A MILLIONAIRE!");
        System.out.println("------------------------------\n");
        
        System.out.println("M A I N   M E N U");
        System.out.println("-----------------");
        System.out.println("[S] Start the game");
        System.out.println("[V] View the rules of the game");
        System.out.println("[X] Exit the game");
        System.out.print("Select Menu [S/V/X]: ");   
    }
    
    public void difficultyOptions() {
        System.out.println("\nChoose Difficulty Options");
        System.out.println("-------------------------");
        System.out.println("[E] Easy");
        System.out.println("[H] Hard");
        System.out.println("[X] Exit");
        System.out.print("Select an option [E/H/X]: ");
    }
    
    public void viewRules() {
        System.out.println("\nGENERAL  RULES");
        System.out.println("1.) The game will automatically chose the question at random from the Question Bank.");
        System.out.println("    Choices are shuffled automatically.\n");
        System.out.println("2.) Questions will not be repeated all throughout the game.\n");
        System.out.println("3.) There are two (2) categories of the game to choose from as follows: ");
        System.out.println("    a.) Easy => This consists of nine (9) questions having 3 questions for each round");
        System.out.println("    b.) Hard => This consists of fifteen (15) questions having 5 questions for each round");
        System.out.println("    NOTE: After each round, you have the option to WALK AWAY or CONTINUE\n");
        System.out.println("4.) There are three (3) Lifelines available as follows:");
        System.out.println("    a.) 50-50 => This lifeline will elimite two (2) incorrect answers.");
        System.out.println("    b.) Ask the Audience => This lifeline will allow the audience to vote their answers.");
        System.out.println("        based on the letter of their choice. Answers will be consolidated and display in ");
        System.out.println("        a percentage format for each letter of choice.");
        System.out.println("    c.) Phone A Friend => This lifeline will allow the player to phone a friend and ask ");
        System.out.println("        the letter of his/her choice based on the given choices.");
        System.out.println("    NOTE: You can only use each lifeline ONCE\n");
        System.out.println("5.) The lifelines are available in Round 2 and 3 for the HARD option while EASY option is ");
        System.out.println("    available at the start.\n");
        System.out.println("6.) After the player chooses their answer for each question, he/she is allowed to confirm ");
        System.out.println("    that the choice selected is their final answer. If the player did not confirm, he/she ");
        System.out.println("    can change the answer to another option.\n");
        System.out.println("7.) Once the player chosen the incorrect answer, he/she lose the game and walk away with ");
        System.out.println("    no money");
    }
}

package UserInterface;

import UserInterface.DisplayExceptionMessage;
import Database.Player;
import BusinessLogic.Game;
import BusinessLogic.Lifeline;
import Database.QuestionBank;
import Exceptions.MillionaireExceptions;
import static java.lang.System.exit;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class EasyOption extends Game {
    private String[] dollarAmount = {"$100","$500","$1,000","$8,000","$16,000","$32,000","$125,000","$500,000","$1,000,000"};
        
    public EasyOption() {
    }

    public EasyOption(Player player, QuestionBank questions, Lifeline lifeline, String charPlayerAns) {
        super(player, questions, lifeline, charPlayerAns);
    }
   
    public String[] getDollarAmount() {
        return dollarAmount;
    }

    public void setDollarAmount(String[] dollarAmount) {
        this.dollarAmount = dollarAmount;
    }

    @Override
    public void start() {    
        Scanner read = new Scanner(System.in);
        Lifeline lifeline = new Lifeline();
        QuestionBank questions = new QuestionBank();
        Random random = new Random();
        int questionNumber = 0;
        int round = 1;
        char confirmRound;
        String confirmLifelineAnswer="";
        char confirmAnswer;
        DisplayExceptionMessage displayExMessage = new DisplayExceptionMessage();
        
        // This is to show the questions from questionSet
        while(questionNumber < 9) {
            int questionIndex = random.nextInt(questions.questionSet.size()); 
            int numChoices = questions.questionSet.get(questionIndex).getChoices().size();
        
            System.out.println(questionNumber+1+". "+ questions.questionSet.get(questionIndex).getQuestion()+"\n");
        
            //This is to display the choices for each questionSet randomly
            for (int choice = 0; choice < numChoices; choice++) {
                char charChoice = (char)(65 + choice);
                System.out.println(charChoice + ": " + questions.questionSet.get(questionIndex).getChoices().get(choice));
            }          
            //Displaying Lifelines
            if(lifeline.visible[0] || lifeline.visible[1] || lifeline.visible[2]) {
                System.out.println("\n====================================");
                System.out.println("Your Available Lifelines");
                for(int i = 0; i < lifeline.visible.length; i++) {
                    if(lifeline.visible[i] == true) {
                        char charChoice = (char)(65 + i);
                        System.out.println(charChoice + ". " + lifeline.displayLifeline[i]);
                    }
                }
                System.out.println("====================================");
                System.out.println("Do you want to use your available lifelines? If YES, enter the corres-"); 
                System.out.print("ponding lifeline letter. Otherwise, any key (1 character) to proceed : "); 
                try {
                    confirmLifelineAnswer = read.next();
                    displayExMessage.returnChoice(confirmLifelineAnswer);
                }
                catch(MillionaireExceptions ex) {
                    System.out.println("Error : "+ex.getMessage());
                    exit(0);
                }
                switch(confirmLifelineAnswer.toUpperCase()){
                    case "A": 
                        if(lifeline.visible[0]) {
                            lifeline.Fifty_fifty(questions.questionSet.get(questionIndex).getChoices(),questions.questionSet.get(questionIndex).getAnswer());
                        }
                        lifeline.visible[0] = false;
                        break;
                    case "B": 
                        if(lifeline.visible[1]) {
                            lifeline.askTheAudience(questions.questionSet.get(questionIndex).getChoices());
                        }
                        lifeline.visible[1] = false;
                        break;
                    case "C": 
                        if(lifeline.visible[2]) {
                            
                            lifeline.phoneAFriend(questions.questionSet.get(questionIndex).getChoices());
                        }
                        lifeline.visible[2] = false;
                        break;
                }
            }

            //To enter the answer of the player and for confirmation
            do {
                System.out.print("\nEnter the letter of your choice [A/B/C/D] : ");
                try {
                    this.charPlayerAns = read.next();
                    displayExMessage.returnAnswerChoice(this.charPlayerAns);
                }
                catch(MillionaireExceptions ex) {
                    System.out.println("\nError : "+ex.getMessage());
                    exit(0);
                }
                
                System.out.print("\nAre you sure, this is your final answer? If YES, enter 'Y', otherwise any key to change your answer. : "); 
                confirmAnswer = read.next().charAt(0);
            } while(Character.toUpperCase(confirmAnswer) != 'Y');

            int playerAnswer = (int)(this.charPlayerAns.toUpperCase().charAt(0)-65);
            

            ArrayList<String> choiceSet = questions.questionSet.get(questionIndex).getChoices(); //to get the choices of the current question

            String correctAnswer = questions.questionSet.get(questionIndex).getAnswer(); 
            
            int correctAnswerIndex = choiceSet.indexOf(correctAnswer); //location index of the correct answer
            
            if (playerAnswer == correctAnswerIndex) {
                if(questionNumber == 8) {
                    System.out.println("\n================================================================");
                    System.out.println("CONGRATULATIONS! You will bring home ===> "+ this.dollarAmount[questionNumber]+" dollars <===");
                    System.out.println("=================================================================\n");
                }
                else {
                    System.out.println("\n====================================================================");
                    System.out.println("You GOT the correct answer! You have now ===> "+ this.dollarAmount[questionNumber]+" dollars <===");
                    System.out.println("====================================================================\n");
                }
                questionNumber++;
            }
            else {
                System.out.println("\n=====================================================================");
                System.out.println("Oh SORRY, you chose the incorrect answer and take home NOTHING.....");
                System.out.println("\nThe correct answer is ===> "+ (char)(choiceSet.indexOf(correctAnswer)+65)+". "+correctAnswer);
                System.out.println("=====================================================================\n");
                break;
            }
            questions.questionSet.remove(questionIndex); //This is to remove the question to avoid repetition
            
            if((questionNumber == 3) || (questionNumber == 6)) {
                System.out.println("CONGRATULATIONS! You have successfully completed Round "+ round);
                round++;
                System.out.print("\nDo you want to WALK AWAY? If NO, enter 'N' to CONTINUE, otherwise ANY KEY to WALK AWAY : ");
                confirmRound = read.next().charAt(0);
                if(Character.toUpperCase(confirmRound)=='N') {
                    System.out.println("\n");
                    continue;
                }
                else {
                    System.out.println("\n========================================================================================");
                    System.out.println("Thank you for participating. You will WALK AWAY with *** " + this.dollarAmount[questionNumber-1]+" *** dollars");
                    System.out.println("========================================================================================\n");
                    break;
                }
            }
        }//end of while loop
        read.close();
    }
}
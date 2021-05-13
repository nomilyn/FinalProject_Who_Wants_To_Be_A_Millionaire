package BusinessLogic;
import java.util.ArrayList;
import java.util.Random;

public class Lifeline {
    public boolean[] visible = {true,true,true};
    public String[] displayLifeline = {"50/50","Ask the Audience","Phone A Friend"};
    
    public Lifeline() {
        
    }
    
    Random random = new Random();
    
    public void Fifty_fifty(ArrayList<String> choices, String correctAnswer) {
        int correctAnswerIndex = 0;
        char letter = 0;
        for(int choiceIndex = 0; choiceIndex < 4; choiceIndex++) {
            letter = (char)(65 + choiceIndex);
            if(correctAnswer == choices.get(choiceIndex)) {
                correctAnswerIndex = choiceIndex;
            }
        }
        System.out.println("\nChoose the letter of your answer below: \n");
        //retain correct answer and get 1 incorrect answer
        int incorrectAnswerIndex=0;
        do {
            incorrectAnswerIndex = random.nextInt(4); //randomize from 0 to 3
        } while(incorrectAnswerIndex==correctAnswerIndex);
        
        if(correctAnswerIndex < incorrectAnswerIndex) {
            System.out.println((char)(correctAnswerIndex+65) + ": " + correctAnswer);
            System.out.println((char)(incorrectAnswerIndex+65) + ": " + choices.get(incorrectAnswerIndex));
        }
        else {
            System.out.println((char)(incorrectAnswerIndex+65) + ": " + choices.get(incorrectAnswerIndex));
            System.out.println((char)(correctAnswerIndex+65) + ": " + correctAnswer);
        }    
    }
    
    public void askTheAudience(ArrayList<String> choices) {
        final int MAX_PERCENTAGE = 100;
        int[] audienceVote = new int[4];   
        
        audienceVote[0] = random.nextInt(MAX_PERCENTAGE);
        audienceVote[1] = random.nextInt(MAX_PERCENTAGE  - audienceVote[0]);
        audienceVote[2] =  random.nextInt(MAX_PERCENTAGE  - (audienceVote[0] + audienceVote[1]));
        audienceVote[3] = MAX_PERCENTAGE - (audienceVote[0] + audienceVote[1] + audienceVote[2]);
        
        System.out.println("\nAudience Percentage Vote Results");
        for(int i = 0; i < audienceVote.length; i++) {
            char select = (char)(65+i);
            System.out.println(audienceVote[i]+ "%" + " ====> " + select + ": " + choices.get(i));
        }
    }
    
    public void phoneAFriend(ArrayList<String> choices) {
        int friendsChoice = random.nextInt(4);
        System.out.println("\nMy friend's choice is ======> " + (char)(friendsChoice+65) +". "+choices.get(friendsChoice));
    }
}

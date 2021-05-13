package BusinessLogic;

import java.util.ArrayList;
import java.util.Collections;

public class Question {
    private String question;
    private ArrayList<String> choices;
    private String correctAnswer;
    
    public Question(String question, String[] choices, String correctAnswer) {
        this.question = question;
        this.choices = new ArrayList<String>();
        
        for (int i = 0; i < choices.length; i++) {
            this.choices.add(choices[i]);
        }
        //This is to shuffle the questions 
        Collections.shuffle(this.choices);
        this.correctAnswer = correctAnswer;
    }
    public String getQuestion() {
        return question;
    }
    public ArrayList<String> getChoices() {
        return choices;
    }
    public String getAnswer() {
        return correctAnswer;
    }
}
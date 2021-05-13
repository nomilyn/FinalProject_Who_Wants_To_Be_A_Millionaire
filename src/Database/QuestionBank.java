package Database;

import BusinessLogic.Question;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionBank {
    
    public ArrayList<Question> questionSet;
    
    public QuestionBank() {
        questionSet = new ArrayList<>();
        //1
        String question = "A magnet would most likely attract which of the following?";
        String[] choices = {"Metal","Plastic","Wood","The wrong man"};
        String correctAnswer = "Metal";
        questionSet.add(new Question(question, choices, correctAnswer));
        //2
        question = "Where did Scotch whisky originate?";
        // Must reuse variable with new String[] since array constants can only be used during initialization
        choices = new String[]{"Ireland","Wales","USA","Scotland"};
        correctAnswer = "Scotland";
        questionSet.add(new Question(question, choices, correctAnswer));
        //3
        question = "In fancy hotels, it is traditional for what tantalizing treat to be left on your pillow?";
        choices = new String[]{"A pretzel","An apple","A mint","A photo of Wolf Blitzer"};
        correctAnswer = "A mint";
        questionSet.add(new Question(question, choices, correctAnswer));
        //4
        question = "In the United States, what is traditionally the proper way to address a judge?";
        choices = new String[]{"Your holiness","Your honor","Your eminence","You da man!"};
        correctAnswer = "Your honor";
        questionSet.add(new Question(question, choices, correctAnswer));
        //5
        question = "In which of these films does Whoopi Goldberg dress up as a nun?";
        choices = new String[]{"Sister Act","Ghost","The Color Purple","How Judas Got His Groove Back"};
        correctAnswer = "Sister Act";
        questionSet.add(new Question(question, choices, correctAnswer));
        //6
        question = "If someone asked to see your ID, what might you show them?";
        choices = new String[]{"Your tongue","Your teeth","Your passport","The door"};
        correctAnswer = "Your passport";
        questionSet.add(new Question(question, choices, correctAnswer));
        //7
        question = "According to the old saying, 'love of' what 'is the root of all evil'?";
        choices = new String[]{"Food","Money","Clothing","Reality television"};
        correctAnswer = "Money";
        questionSet.add(new Question(question, choices, correctAnswer));
        //8
        question = "A well-known lyric in the holiday song 'Silver Bells' promises that 'soon it will be' what?";
        choices = new String[]{"July 4th weekend","Halloween night","Christmas Day","National Burrito Month"};
        correctAnswer = "Christmas Day";
        questionSet.add(new Question(question, choices, correctAnswer));
        //9
        question = "What does the letter 'S' stand for in the abbreviation SIM, as in SIM card?";
        choices = new String[]{"Subscriber","Single","Secure","Solid"};
        correctAnswer = "Subscriber";
        questionSet.add(new Question(question, choices, correctAnswer));
        //10
        question = "What word represents the letter 'T' in the NATO phonetic alphabet?";
        choices = new String[]{"Tango","Target","Taxi","Turkey"};
        correctAnswer = "Tango";
        questionSet.add(new Question(question, choices, correctAnswer));
        //11
        question = "When one is 'envious', they are said to be what color?";
        choices = new String[]{"Green","Red","Blue","Yellow"};
        correctAnswer = "Green";
        questionSet.add(new Question(question, choices, correctAnswer));
        //12
        question = "The Canadian $1 coin is colloquially known as a what?";
        choices = new String[]{"Loonie","Boolie","Foolie","Moodie"};
        correctAnswer = "Loonie";
        questionSet.add(new Question(question, choices, correctAnswer));
        //13
        question = "How many colors are there in a rainbow?";
        choices = new String[]{"7","8","9","10"};
        correctAnswer = "7";
        questionSet.add(new Question(question, choices, correctAnswer));
        //14
        question = "Which of these colours is NOT featured in the logo for Google?";
        choices = new String[]{"Pink","Yellow","Blue","Green"};
        correctAnswer = "Pink";
        questionSet.add(new Question(question, choices, correctAnswer));
        //15
        question = "Which of the following card games revolves around numbers and basic math?";
        choices = new String[]{"Uno","Go Fish","Twister","Munchkin"};
        correctAnswer = "Uno";
        questionSet.add(new Question(question, choices, correctAnswer));
        
        Collections.shuffle(questionSet, new Random());
    }

    public QuestionBank(ArrayList<Question> questionSet) {
        this.questionSet = questionSet;
    }

    public ArrayList<Question> getQuestionSet() {
        return questionSet;
    }

    public void setQuestionSet(ArrayList<Question> questionSet) {
        this.questionSet = questionSet;
    }
}

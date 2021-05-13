package BusinessLogic;

import BusinessLogic.Lifeline;
import Database.QuestionBank;
import Database.Player;

public abstract class Game { 
    protected Player player;
    protected QuestionBank questions;
    protected Lifeline lifeline;
    protected String charPlayerAns;
            
    public Game() { 
        
    }
    
    public Game(Player player, QuestionBank questions, Lifeline lifeline, String charPlayerAns) {
        this.player = player;
        this.questions = questions;
        this.lifeline = lifeline;
        this.charPlayerAns = charPlayerAns;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public QuestionBank getQuestions() {
        return questions;
    }

    public void setQuestions(QuestionBank questions) {
        this.questions = questions;
    }

    public Lifeline getLifeline() {
        return lifeline;
    }

    public void setLifeline(Lifeline lifeline) {
        this.lifeline = lifeline;
    }

    public String getCharPlayerAns() {
        return charPlayerAns;
    }

    public void setCharPlayerAns(String charPlayerAns) {
        this.charPlayerAns = charPlayerAns;
    }

    public abstract void start();
}




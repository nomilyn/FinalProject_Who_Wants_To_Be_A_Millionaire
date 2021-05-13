package UserInterface;

import Exceptions.MillionaireExceptions;

public class DisplayExceptionMessage {
    //Handling exceptions
    public String returnChoice(String choice) throws MillionaireExceptions {
        if(choice.length() > 1) {
            throw new MillionaireExceptions("You have entered more than 1 character!\n");
        }
        else if(choice.length() == 0) {
            throw new MillionaireExceptions("You must enter any letter!\n");
        }
        return choice;
    }
    
    public String returnAnswerChoice(String choice) throws MillionaireExceptions {
        if(choice.length() > 1) {
            throw new MillionaireExceptions("You have entered more than 1 character!\n");
        }
        else if (!((choice.equalsIgnoreCase("A")) || (choice.equalsIgnoreCase("B")) || (choice.equalsIgnoreCase("C")) || (choice.equalsIgnoreCase("D")))) {
            throw new MillionaireExceptions("You have entered an incorrect letter!!!\n");
        }
        return choice;
    }
}

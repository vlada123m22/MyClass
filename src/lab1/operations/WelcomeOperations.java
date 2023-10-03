package lab1.operations;

import java.util.Scanner;

public class WelcomeOperations extends Operations{

    @Override
    public void displayMessage() {
        message= """
                
                
                
                
                Welcome to TUM's management system! What do you want to do?
                
                g - general operations
                f - faculty operations
                s - student operations
                
                q - quit program
                
                your input>""";
        System.out.println(message);
    }

    @Override
    public void getInput(String[] tokens) {
        String choice=tokens[0];
        if (choice.equals("g") || choice.equals("f")||choice.equals("s")) {
            this.choice = choice;
            this.executeChoice();

        }
        else {
            System.out.println("Invalid input! Try one more time!");
            this.executeChoice();
        }

//        TODO close scanner
    }

    @Override
    public void executeChoice() {
        switch (choice) {
            case "g" -> {
                ApplicationLoop.currentOpperation=1;
            }
            case "f" -> {
                ApplicationLoop.currentOpperation=2;
            }

            case "s"->{

                System.out.println("Student operations not defined yet!!!");
            }

        }
    }


}

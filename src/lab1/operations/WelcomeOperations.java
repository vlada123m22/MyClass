package lab1.operations;

import java.util.Scanner;

public class WelcomeOperations extends Operations{



    public WelcomeOperations(){
        super();
    }

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
    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        if (choice.equals("g") || choice.equals("f")||choice.equals("s")||choice.equals("q")) {
            this.choice = choice;
            this.executeChoice();

        }
        else {
            System.out.println("Invalid input! Try one more time!");
            this.executeChoice();
        }

    }

    @Override
    public void executeChoice() {
        switch (choice) {
            case "g" -> {
                GeneralOperations generalOperations = new GeneralOperations();
                generalOperations.getInput();
            }
            case "f" -> {
                FacultyOperations facultyOperations = new FacultyOperations();
                facultyOperations.getInput();
            }

            case "s"->{

                System.out.println("Student operations not defined yet!!!");
                this.displayMessage();
                this.getInput();
            }

            case "q" -> System.out.println("Quited the program");
        }
    }


}

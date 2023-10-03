package lab1.operations;

import lab1.file_manager.FacultyManager;
import lab1.file_manager.LogManager;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ApplicationLoop {
    static int currentOpperation=0;//0-welcome, 1- general, 2- faculty
    public ApplicationLoop() {
//        LogManager logManager=new LogManager();
//        try {
//            logManager.addLog(input,new File("lab1/log.txt"));
//        } catch (IOException e) {
//            System.out.println("file lab1/log.txt not found or cannot write to file");
//        }

        Scanner scanner = new Scanner(System.in);
        String input = "c";
        String [] inputTokens = input.split("/");


        while (!inputTokens[0].equals("q")) {

            switch (currentOpperation){
                case 0 ->{
                    WelcomeOperations welcomeOperations=new WelcomeOperations();
                    welcomeOperations.displayMessage();
                    input = scanner.nextLine();
                    inputTokens = input.split("/");
                    welcomeOperations.getInput(inputTokens);

                }
                case 1 -> {
                    GeneralOperations generalOperations=new GeneralOperations();
                    generalOperations.displayMessage();
                    input = scanner.nextLine();
                    inputTokens = input.split("/");
                    generalOperations.getInput(inputTokens);
                }
                case 2 -> {
                    FacultyOperations facultyOperations=new FacultyOperations();
                    facultyOperations.displayMessage();
                    input = scanner.nextLine();
                    inputTokens = input.split("/");
                    facultyOperations.getInput(inputTokens);
                }
            }
        }
        scanner.close();
        System.out.println("Quited the program");
    }

}

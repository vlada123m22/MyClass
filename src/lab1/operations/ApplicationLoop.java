package lab1.operations;

import lab1.file_manager.FacultyManager;
import lab1.file_manager.LogManager;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ApplicationLoop {
    private Scanner scanner;
    private String input;
    private String [] inputTokens;
    private LogManager logManager = new LogManager();
    static int currentOpperation=0;//0-welcome, 1- general, 2- faculty

    public ApplicationLoop() {
         this.scanner = new Scanner(System.in);
    }

    public void run() {
        executeOpperation(new WelcomeOperations());

        while (!inputTokens[0].equals("q")) {

            switch (currentOpperation){
                case 0 -> executeOpperation(new WelcomeOperations());
                case 1 -> executeOpperation(new GeneralOperations());
                case 2 -> executeOpperation(new FacultyOperations());
            }
        }
        scanner.close();
        System.out.println("Quited the program");
    }

    public void executeOpperation(Operations operations){

        operations.displayMessage();
        input=scanner.nextLine();
        inputTokens=input.split("/");
        try {
            logManager.addLog(input, new File("src/lab1/log.txt"));
        } catch (IOException e) {
            System.out.println("Cannot write the file lab1/log.txt or it doesn't exist at the specified path");
        }
        operations.getInput(inputTokens);


    }
}

package lab2.tracking;

import lab2.fileinfo.FileInfo;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationLoop extends Thread {
    public static final String MESSAGE= """
   What do you want to do?
   Available operations:
   commit
   status
   info<filename>
   quit
   """;
    String command;
    public  void run(){
        try {
            this.executeCommands();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeCommands() throws IOException {
        boolean flag=true;

        while (flag) {
            Commands commands = new Commands();
            Scanner scanner = new Scanner(System.in);
            this.command = scanner.nextLine();
            switch (command) {
                case "commit" -> Commands.commit();
                case "status" -> commands.status();
                case "quit" -> flag=false;
                default -> {
                    String [] commandTokens = command.split(" ");
                    if (commandTokens.length != 2 ){
                        System.out.println("Introduced wrong command");
                    }else if(!commandTokens[0].equals("info")){
                        System.out.println("Introduced wrong command");
                    }else {
                        String filename = commandTokens[1];
                        commands.printInfo(filename);
                    }
                }
            }
        }


    }
}

package Lab2;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(System.in);
        String command =scanner.nextLine();
        File location = new File("C:\\Univer\\OOP\\untitled\\src");
        while(!command.equals("exit"))  {
            TerminalProcess.runCommand(location, command);
            command=scanner.nextLine();
        }
    }
}

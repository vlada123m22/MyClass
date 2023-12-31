package lab1.operations;

import lab1.entities.Faculty;
import lab1.entities.Student;
import lab1.file_manager.FacultyManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class GeneralOperations extends Operations{
    String[] choiceTokens;
    @Override
    public void displayMessage() {
        message = """
                
                
                
                
                General operations
                What do you want to do?

                nf/<faculty name>/<faculty abbreviation>/<field> - create faculty
                ss/<student email> - search student and show faculty
                df -  display faculties
                df/<field> - display all faculties of a field
                
                b- Back
                q- Quit Program
                your input>""";
        System.out.println(message);

    }

    @Override
    public void getInput(String [] tokens)  {

        if (tokens[0].equals("nf") || tokens[0].equals("ss")||tokens[0].equals("df")||tokens[0].equals("b")||tokens[0].equals("q")){
            this.choice = tokens[0];
            this.choiceTokens=tokens;
            this.executeChoice();
        }
        else {
            System.out.println("Incorrect input!Try one more time!");
        }
    }

    @Override
    public void executeChoice() {
        switch (choice) {
            case "nf" -> {
                Faculty faculty =new Faculty(choiceTokens[1], choiceTokens[2], choiceTokens[3]);
                FacultyManager fm = new FacultyManager();
                try {
                    fm.addRecording(faculty, new File("src/lab1/faculties.txt"),"/");
                } catch (IOException e) {
                    System.out.println("The file faculties.txt doesn't exist at the indicated path, or it's impossible to read it");
                }
                System.out.println("New faculty created");
            }
            case "ss" -> {
                String email = choiceTokens[1];
                Student student = Student.getStudentByEmail(email);
                Faculty faculty = Faculty.getFacultyByStudentEmail(email);
                System.out.println("Student: " + student.toString() + "from faculty: " + faculty.toString() + "\n");
            }
            case "df" -> {
                try {
                    List<Faculty> faculties = Faculty.getFacultiesByField(choiceTokens[1]);
                    for (Faculty f :
                            faculties) {
                        System.out.println(f.toString());
                    }
                } catch (ArrayIndexOutOfBoundsException e){ //If after "df" the name of the field is not present then an ArrayOutOfBoundException will be thrown
                    List<Faculty> faculties = Faculty.getAllFaculties();
                    for (Faculty f :
                            faculties) {
                        System.out.println(f.toString());
                    }
                }
            }
            case "b" -> {
                ApplicationLoop.currentOpperation=0;
            }
            default -> System.out.println("Incorrect input! Try one more time!");
        }

    }


}

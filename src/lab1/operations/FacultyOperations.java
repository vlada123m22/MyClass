package lab1.operations;

import lab1.Faculty;
import lab1.Student;
import lab1.file_manager.StudentManager;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class FacultyOperations extends Operations{
String[] choiceTokens;
public FacultyOperations(){
    super();
}
    @Override
    public void displayMessage() {
        message= """
                Faculty operations
                What do you want to do?
                
                ns/<faculty abbreviation>/<first name>/<last name>/<email>/<day>/<month>/<year>- create student
                gs/<email> - (g)raduate (s)tudent
                ds/<faculty abbreviation>- (d)isplay enrolled (s)tudents
                dg/<faculty abbreviation>- (d)isplay (g)raduated students
                bf/<faculty abbreviation>/<email> - check if student (b)elongs to (f)aculty
                
                b- Back
                q Quit Program
                your input>""";
        System.out.println(message);
    }

    @Override
    public void getInput()  {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        String[] tokens = choice.split("/");
        if (tokens[0].equals("ns") || tokens[0].equals("gs")||tokens[0].equals("ds")||tokens[0].equals("dg")||tokens[0].equals("bf")||tokens[0].equals("b")||tokens[0].equals("q")) {
            this.choice = tokens[0];
            this.choiceTokens = tokens;
            this.executeChoice();
        }
        else {
            System.out.println("Incorrect input!Try one more time!");
            this.getInput();
        }
    }

    @Override
    public void executeChoice() {
        switch (choice) {
            case "ns" -> {
                String abreviation = choiceTokens[1];
                Faculty faculty = Faculty.getFacultyByAbreviation(abreviation);

                int birthYear = Integer.parseInt(choiceTokens[5]);
                int birthMonth = Integer.parseInt(choiceTokens[6]);
                int birthDay = Integer.parseInt(choiceTokens[7]);
                Student student = new Student(choiceTokens[2], choiceTokens[3], choiceTokens[4], birthYear, birthMonth, birthDay);
                student.setFacultyAbreviation(faculty.getAbbreviation());
                StudentManager sm=new StudentManager();
                try {
                    sm.addRecording(student, new File("src/lab1/students.txt"), "/");
                } catch (IOException e) {
                    System.out.println("The file students.txt does not exist at the indicated path or cannot be read");
                }
                System.out.println("Student added");
                this.getInput();
            }
            case "gs" -> {
                String email = choiceTokens[1];
                Student student = Student.getStudentByEmail(email);
                student.setGraduated(true);
                System.out.println("Student "+email+" setted as graduated");
                this.getInput();
            }
            case "ds" -> {
                String abbreviation = choiceTokens[1];
                Faculty faculty = Faculty.getFacultyByAbreviation(abbreviation);
                List<Student> enrolled = faculty.getEnrolledStudents();
                for (Student s :
                        enrolled) {
                    System.out.println(s.toString());
                }
                this.getInput();
            }
            case "dg" -> {
                String abbreviation = choiceTokens[1];
                Faculty faculty = Faculty.getFacultyByAbreviation(abbreviation);
                List<Student> graduates = faculty.getGraduates();
                for (Student g :
                        graduates) {
                    System.out.println(g.toString());
                }
                this.getInput();
            }
            case "bf" -> {
                String abbreviation = choiceTokens[1];
                String email = choiceTokens[2];
                Faculty faculty = Faculty.getFacultyByAbreviation(abbreviation);
                Student student = Student.getStudentByEmail(email);
                if (faculty.hasStudent(student)) System.out.println("The student belongs to this faculty");
                else System.out.println("The student doesn't belong to this faculty");
                this.getInput();
            }
            case "b" -> {
                new WelcomeOperations();
            }
            case "q" -> System.out.println("Quited the program");
        }
    }
}

package lab1.operations;

import lab1.entities.Faculty;
import lab1.entities.Student;
import lab1.file_manager.StudentManager;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FacultyOperations extends Operations{
String[] choiceTokens;
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
    public void getInput(String[] tokens)  {
        if (tokens[0].equals("ns") || tokens[0].equals("gs")||tokens[0].equals("ds")||tokens[0].equals("dg")||tokens[0].equals("bf")||tokens[0].equals("b")||tokens[0].equals("q")) {
            this.choice = tokens[0];
            this.choiceTokens = tokens;
            this.executeChoice();
        }
        else {
            System.out.println("Incorrect input!Try one more time!");
        }
    }

    @Override
    public void executeChoice() {
        switch (choice) {
            case "ns" -> {
                String abreviation = choiceTokens[1];
                Faculty faculty = Faculty.getFacultyByAbreviation(abreviation);
                Student student = new Student();
                student.setFirstName(choiceTokens[2]);
                student.setLastName(choiceTokens[3]);
                student.setEmail(choiceTokens[4]);
                student.setDateOfBirth(choiceTokens[5], choiceTokens[6], choiceTokens[7]);

                student.setFacultyAbreviation(faculty.getAbbreviation());
                StudentManager sm=new StudentManager();
                try {
                    sm.addRecording(student, new File("src/lab1/students.txt"), "/");
                } catch (IOException e) {
                    System.out.println("The file students.txt does not exist at the indicated path or cannot be read");
                }
                System.out.println("Student added");

            }
            case "gs" -> {
                String email = choiceTokens[1];
                Student student = Student.getStudentByEmail(email);
                student.setGraduated(true);
                System.out.println("Student "+email+" setted as graduated");
            }
            case "ds" -> {
                String abbreviation = choiceTokens[1];
                Faculty faculty = Faculty.getFacultyByAbreviation(abbreviation);
                List<Student> enrolled = faculty.getEnrolledStudents();
                for (Student s :
                        enrolled) {
                    System.out.println(s.toString());
                }
            }
            case "dg" -> {
                String abbreviation = choiceTokens[1];
                Faculty faculty = Faculty.getFacultyByAbreviation(abbreviation);
                List<Student> graduates = faculty.getGraduates();
                for (Student g :
                        graduates) {
                    System.out.println(g.toString());
                }
            }
            case "bf" -> {
                String abbreviation = choiceTokens[1];
                String email = choiceTokens[2];
                Faculty faculty = Faculty.getFacultyByAbreviation(abbreviation);
                Student student = Student.getStudentByEmail(email);
                if (faculty.hasStudent(student)) System.out.println("The student belongs to this faculty");
                else System.out.println("The student doesn't belong to this faculty");
            }
            case "b" -> {
                ApplicationLoop.currentOpperation=0;
            }
        }
    }
}

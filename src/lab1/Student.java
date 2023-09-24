package lab1;


import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Student {
private String firstName;
private String lastName;
private String email;
private Date enrolementDate;
private Date dateOfBirth;
private boolean graduated=false;
public static List<Student> allstudents;


    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName=lastName;
        allstudents.add(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getEnrolementDate() {
        return enrolementDate;
    }

    public void setEnrolementDate(Date enrolementDate) {
        this.enrolementDate = enrolementDate;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }



    public static Student getStudentByEmail(String email){
        List<Student>students = Student.allstudents;
        Iterator<Student> iterator=students.iterator();
        while (iterator.hasNext()){
            Student student =iterator.next();
            if(student.email.equals(email)){
                return student;
            }
        }
        return null;
    }

    public static Faculty getFacultyByEmail(String email){
        Student student=getStudentByEmail(email);
        if (student==null) return null;
        List<Faculty>faculties = Faculty.allFaculties;
        Iterator<Faculty> iterator=faculties.iterator();
        while (iterator.hasNext()){
            Faculty faculty=iterator.next();

            if(faculty.hasStudent(student)){
                return faculty;
            }
        }
        return null;
    }
}

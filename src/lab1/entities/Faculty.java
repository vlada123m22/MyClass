package lab1.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Faculty {

    private String name;
    private String abbreviation;
    private List<Student> studentsList=new ArrayList<>();
    private StudyField studyField;
    public static List<Faculty> allFaculties=new ArrayList<>();

    public Faculty(){allFaculties.add(this);};

    public Faculty(String name, String abbreviation, String studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = StudyField.valueOf(studyField);
        allFaculties.add(this);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(List<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public StudyField getStudyField() {
        return studyField;
    }

    public void setStudyField(String studyField) {
        this.studyField = StudyField.valueOf(studyField);
    }



    public List<Student> getEnrolledStudents(){
        Iterator<Student> iterator=studentsList.iterator();
        List<Student> enrolledStudents=new ArrayList<>();
        while (iterator.hasNext()){
            Student student=iterator.next();
            if (!student.isGraduated()){
                enrolledStudents.add(student);
            }
        }
        return enrolledStudents;
    }

    public List<Student> getGraduates(){
        Iterator<Student> iterator=studentsList.iterator();
        List<Student> graduates=new ArrayList<>();
        while (iterator.hasNext()){
            Student student=iterator.next();
            if (student.isGraduated()){
                graduates.add(student);
            }
        }
        return graduates;
    }




    public boolean hasStudent(Student student){
        Iterator<Student> iterator=studentsList.iterator();
        while (iterator.hasNext()){
            if (iterator.next()==student){
                return true;
            }
        }
        return false;
    }

    public void addStudent( Student student){
        studentsList.add(student);
    }



    public static List<Faculty> getAllFaculties(){
        return allFaculties;
    }

    public static List<Faculty> getFacultiesByField(String field){
        List<Faculty> filteredFaculties=new ArrayList<>();
        Iterator<Faculty> iterator=Faculty.allFaculties.iterator();
        while (iterator.hasNext()){
            Faculty faculty=iterator.next();
            String studyField= String.valueOf(faculty.studyField);
            if (studyField.equals(field)){
                filteredFaculties.add(faculty);
            }
        }
        return filteredFaculties;
    }



    public static Faculty getFacultyByStudentEmail(String email){
        Student student=Student.getStudentByEmail(email);//Studentul il citeste cum trebuie
        if (student==null) return null;
        List<Faculty>faculties = Faculty.allFaculties;//Why the recordings are doubled in allFaculties
        Iterator<Faculty> iterator=faculties.iterator();
        while (iterator.hasNext()){
            Faculty faculty=iterator.next();

            if(faculty.hasStudent(student)){
                return faculty;
            }
        }
        return null;
    }

    public static Faculty getFacultyByAbreviation(String abreviation){
        Iterator<Faculty> iterator=Faculty.allFaculties.iterator();
        while (iterator.hasNext()){
            Faculty faculty=iterator.next();
            if (abreviation.equals(faculty.abbreviation)){
                return faculty;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.abbreviation+" - "+ this.name;
    }



}

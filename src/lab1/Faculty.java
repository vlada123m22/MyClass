package lab1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Faculty {

    private String name;
    private String abbreviation;
    private List<Student> studentsList;
    private StudyField studyField;
    static List<Faculty> allFaculties;

    public Faculty(String name, String abbreviation, StudyField studyField) {
        this.name = name;
        this.abbreviation = abbreviation;
        this.studyField = studyField;
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

    public void setStudyField(StudyField studyField) {
        this.studyField = studyField;
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

    public List<Faculty> getAllFaculties(){
        return allFaculties;
    }

    public List<Faculty> getFacultiesByField(StudyField field){
        List<Faculty> filteredFaculties=new ArrayList<>();
        Iterator<Faculty> iterator=Faculty.allFaculties.iterator();
        while (iterator.hasNext()){
            Faculty faculty=iterator.next();
            if (faculty.studyField==field){
                filteredFaculties.add(faculty);
            }
        }
        return filteredFaculties;
    }

}

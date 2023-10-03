package lab1.entities;


import java.util.*;

public class Student {
private String firstName;
private String lastName;
private String email;
private Date enrolementDate;
private Date dateOfBirth;
private String facultyAbreviation;
private boolean graduated=false;

public static List<Student> allstudents=new ArrayList<>();


public Student(){allstudents.add(this);}


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

    public String getEnrolementDate(String delimiter) {
    if (this.enrolementDate==null){
        this.enrolementDate=new Date();
    }
    int date = this.enrolementDate.getDate();
    int month =this.enrolementDate.getMonth()+1;
    int year = this.enrolementDate.getYear()+1900;
        return date+delimiter+month+delimiter+year;

    }

    public String getDateOfBirth(String delimiter) {
        int date = this.dateOfBirth.getDate();
        int month =this.dateOfBirth.getMonth()+1;
        int year = this.dateOfBirth.getYear()+1900;
        return date+delimiter+month+delimiter+year;

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


    public void setDateOfBirth(String birthDay, String birthMonth, String birthYear){
    int day=Integer.parseInt(birthDay);
    int month = Integer.parseInt(birthMonth)-1;
    int year=Integer.parseInt(birthYear);
    if (year<1950||year>2050){
        System.out.println("Warning! The year "+year+" might not have been introduced correctly the birth year for student "+this.email);
    }
    if ((month<12)&&(month>=0)){
        switch (month) {
            case Calendar.JANUARY, Calendar.MARCH, Calendar.MAY, Calendar.JULY, Calendar.AUGUST, Calendar.OCTOBER, Calendar.DECEMBER -> {
                if (day < 1 || day > 31) {
                    System.out.println("ERROR! Introduced incorrectly the day of the month for student "+this.email);
                    return;
                }
            }
            case Calendar.APRIL, Calendar.JUNE, Calendar.SEPTEMBER, Calendar.NOVEMBER -> {
                if (day < 1 || day > 30) {
                    System.out.println("ERROR! Introduced incorrectly the day of the month for student "+ this.email);
                    return;
                }
            }
            case Calendar.FEBRUARY -> {
                if (year%4==0&&(day<1||day>29)||year%4!=0&&(day<1||day>28)){//verifies if the day for the month february is not out of range taking into considaration the bisect year
                    System.out.println("ERROR! Introduced incorrectly the day of the month for student "+this.email);
                    return;
                }
            }
        }

        this.dateOfBirth=new Date(year-1900,month,day);
    }
    else System.out.println("ERROR! Introduced inexisting month for student "+this.email);

    }

    public void setEnrolementDate(String enrollmentDate, String enrollmentMonth, String enrollmentYear){
        int day=Integer.parseInt(enrollmentDate);
        int month = Integer.parseInt(enrollmentMonth)-1;
        int year=Integer.parseInt(enrollmentYear);
        if (year<1950||year>2050){
            System.out.println("Warning! The year "+year+" might not have been introduced correctly the enrollment year for student "+this.email);
        }
        if ((month<12)&&(month>=0)){
            switch (month) {
                case Calendar.JANUARY, Calendar.MARCH, Calendar.MAY, Calendar.JULY, Calendar.AUGUST, Calendar.OCTOBER, Calendar.DECEMBER -> {
                    if (day < 1 || day > 31) {
                        System.out.println("ERROR! Introduced incorrectly the day of the month for student "+this.email);
                        return;
                    }
                }
                case Calendar.APRIL, Calendar.JUNE, Calendar.SEPTEMBER, Calendar.NOVEMBER -> {
                    if (day < 1 || day > 30) {
                        System.out.println("ERROR! Introduced incorrectly the day of the month for student "+ this.email);
                        return;
                    }
                }
                case Calendar.FEBRUARY -> {
                    if (year%4==0&&(day<1||day>29)||year%4!=0&&(day<1||day>28)){//verifies if the day for the month february is not out of range taking into considaration the bisect year
                        System.out.println("ERROR! Introduced incorrectly the day of the month for student "+this.email);
                        return;
                    }
                }
            }

            this.enrolementDate=new Date(year,month,day);
        }
        else System.out.println("ERROR! Introduced inexisting month for student "+this.email);

    }
    public boolean isGraduated() {
        return graduated;
    }

    public void setGraduated(boolean graduated) {
        this.graduated = graduated;
    }

    public String getFacultyAbreviation() {
        return facultyAbreviation;
    }

    public void setFacultyAbreviation(String facultyAbreviation) {
        this.facultyAbreviation = facultyAbreviation;
        Faculty faculty=Faculty.getFacultyByAbreviation(facultyAbreviation);
        faculty.addStudent(this);
    }

    public static Student getStudentByEmail(String email){
        List<Student>students = Student.allstudents;
        Iterator<Student> iterator=students.iterator();
        while (iterator.hasNext()){
            Student student =iterator.next();
            if(student.getEmail().equals(email)){
                return student;
            }
        }
        return null;
    }

    @Override
    public String toString(){
        return this.firstName+" "+this.lastName;
    }


}

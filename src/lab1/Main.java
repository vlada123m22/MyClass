package lab1;

import lab1.file_manager.FacultyManager;
import lab1.file_manager.StudentManager;
import lab1.operations.ApplicationLoop;
import lab1.operations.FacultyOperations;
import lab1.operations.WelcomeOperations;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {


        FacultyManager facultyManager = new FacultyManager();
        StudentManager studentManager = new StudentManager();
        facultyManager.readRecordings(new File("src/lab1/faculties.txt"), "/");
        studentManager.readRecordings(new File("src/lab1/students.txt"), "/");
        new ApplicationLoop();

    }
}

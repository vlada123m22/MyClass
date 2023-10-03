package lab1.file_manager;

import lab1.entities.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentManager implements FileManager{
    @Override
    public void readRecordings(File file, String delimiter) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] recording = scanner.nextLine().split(delimiter);
            Student student = new Student();
            student.setFirstName(recording[0]);
            student.setLastName(recording[1]);
            student.setEmail(recording[2]);
            student.setEnrolementDate(recording[6], recording[7], recording[8]);
            student.setDateOfBirth(recording[3],recording[4],recording[5]);
            student.setFacultyAbreviation(recording[9]);
            student.setGraduated(Boolean.parseBoolean(recording[10]));
        }
        scanner.close();

    }

    @Override
    public void addRecording(Object recording, File file, String delimiter) throws IOException {
        Student student= (Student) recording;
        FileWriter writer=new FileWriter(file,true);
        String birthDate=student.getDateOfBirth(delimiter);
        String enrollmentDate=student.getEnrolementDate(delimiter);
        writer.write(student.getFirstName()+delimiter+student.getLastName()+delimiter+student.getEmail()+delimiter+enrollmentDate+delimiter+birthDate+delimiter+student.getFacultyAbreviation()+delimiter+String.valueOf(student.isGraduated())+"/n");
        writer.close();
    }
}

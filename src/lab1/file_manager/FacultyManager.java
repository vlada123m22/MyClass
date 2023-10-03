package lab1.file_manager;

import lab1.entities.Faculty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FacultyManager implements FileManager {

    @Override
    public void readRecordings(File file, String delimiter) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String[] recording = scanner.nextLine().split(delimiter);
            Faculty faculty = new Faculty();
            faculty.setName(recording[0]);
            faculty.setAbbreviation(recording[1]);
            faculty.setStudyField(recording[2]);
        }
        scanner.close();

    }

    @Override
    public void addRecording(Object recording, File file, String delimiter) throws IOException {
        Faculty faculty= (Faculty) recording;
        FileWriter writer=new FileWriter(file, true);
        writer.write(faculty.getName()+delimiter+faculty.getAbbreviation()+delimiter+faculty.getStudyField().toString()+"/n"); //Check if faculty.getStudyField().toString() doesn't give incorrect output
        writer.close();
    }
}

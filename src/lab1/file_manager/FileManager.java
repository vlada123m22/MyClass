package lab1.file_manager;

import lab1.Faculty;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface FileManager {
    public void readRecordings(File file, String delimiter) throws FileNotFoundException;
    public void addRecording(Object recording, File file, String delimiter) throws IOException;
}

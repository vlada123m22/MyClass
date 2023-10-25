package lab2.tracking;

import lab2.fileinfo.FileInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DetectionFlow extends Thread {
    private static final String DIRECTORY_PATH="src/lab1";
    private  Set<String> fileNames;
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
                Commands commands = new Commands();
                commands.printChanges();
            } catch (InterruptedException | IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

//    public void detectChanges() throws IOException {
//
//        for (String fileName:
//                fileNames) {
//            FileInfo file = new FileInfo(DIRECTORY_PATH+"/"+fileName);
//            if (file.getCreationTime().compareTo(FileTime.from(Instant.now().minusMillis(5000)))>0){
//                System.out.println("created "+fileName);
//                continue;
//            }
//            if (file.getLastModifiedTime().compareTo(FileTime.from(Instant.now().minusMillis(5000)))>0) {
//                System.out.println("the file "+fileName +" was changed");
//            }
//
//        }
//
//    }
}

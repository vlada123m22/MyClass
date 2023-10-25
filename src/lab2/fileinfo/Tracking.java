//package lab2.fileinfo;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.time.LocalDateTime;
//
//public abstract class Tracking {
//    private final String directory="src/lab1";
//
//    LocalDateTime lastCommit;
//    BasicFileAttributes fileAttributes;
//
//    Tracking(String filepath) throws IOException {
//    this.fileAttributes= Files.readAttributes(Path.of(filepath),BasicFileAttributes.class);
//    }
//
//    public void commit(){
//    this.lastCommit=LocalDateTime.now();
//    }
//    public void printInfo(){
//
//    }
//
//}

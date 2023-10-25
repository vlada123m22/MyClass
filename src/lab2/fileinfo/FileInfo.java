package lab2.fileinfo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public class FileInfo {
    private String filePath;
    private  String fileName;
    private  String extension;
    private  FileTime lastModifiedTime;
    private  FileTime creationTime;
//    private FileTime lastCommitTime;

    public FileInfo(String filePath) throws IOException {
        this.filePath=filePath;
            BasicFileAttributes attrs = Files.readAttributes(Path.of(filePath), BasicFileAttributes.class);
            this.lastModifiedTime=attrs.lastModifiedTime();
            this.creationTime=attrs.creationTime();
            this.fileName= filePath.substring(filePath.lastIndexOf("/") + 1);
            this.extension= fileName.substring(fileName.lastIndexOf(".") + 1);


    }
    public String getFileName(){
        return this.fileName;
    }
    public String getExtension(){
        return this.extension;
    }

    public FileTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public FileTime getCreationTime() {
        return creationTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public void setLastModifiedTime(FileTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void setCreationTime(FileTime creationTime) {
        this.creationTime = creationTime;
    }

    //TODO setLastCommitTime(new FileTime(Instant.now()) -will set the last commit time to the current time
    //TODO compare lastCommitTime with BasicFileAttributes.lastModifiedTime() in order to see if the file was modified after the commit
    //TODO if BasicFileAttributes.creationTime()>lastCommitTime return newFile()=true;
//    public FileTime getLastCommitTime() {
//        return lastCommitTime;
//    }
//
//    public void setLastCommitTime(FileTime lastCommitTime) {
//        this.lastCommitTime = lastCommitTime;
//    }
//
//    public boolean changedSinceCommit(){
//        return true;
//    }

    public void printInfo() {
        System.out.println("extension: "+this.extension+"\nCreated date and time: "+this.creationTime+"\nLast updated date and time: "+ this.lastModifiedTime);
    }

}

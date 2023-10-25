package lab2.tracking;

import lab2.fileinfo.FileInfo;
import lab2.fileinfo.ImageInfo;
import lab2.fileinfo.ProgramInfo;
import lab2.fileinfo.TextInfo;

import java.io.File;
import java.io.IOException;
import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public  class Commands {
    private static final String DIRECTORY_PATH="src/lab1";
    private final Set<String> FILE_NAMES;
    private static FileTime lastCommit;

    public Commands() {
        this.FILE_NAMES = Stream.of(Objects.requireNonNull(new File(DIRECTORY_PATH).listFiles()))
                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toSet());

    }

    public static void commit(){
        lastCommit=FileTime.from(Instant.now());
    }

    public void status() throws IOException {
        FileInfo file;
        boolean directoryChanged=false;
        for (String fileName:
             FILE_NAMES) {
            file = new FileInfo(DIRECTORY_PATH+"/"+fileName);
            if (file.getCreationTime().compareTo(lastCommit)>0){
                System.out.println("SINCE The LAST COMMIT CREATED FILE "+fileName);
                directoryChanged=true;
                continue;
            }
            if (file.getLastModifiedTime().compareTo(lastCommit)>0) {
                System.out.println("SINCE THE LAST COMMIT THE FILE "+fileName +" WAS CHANGED");
                directoryChanged=true;
            }

        }
        if (!directoryChanged) System.out.println("No changes since last commit");

    }

    public void printChanges() throws IOException {
        FileInfo file;
        boolean directoryChanged=false;
        for (String fileName:
                FILE_NAMES) {
            file = new FileInfo(DIRECTORY_PATH+"/"+fileName);
            if (file.getCreationTime().compareTo(FileTime.from(Instant.now().minusMillis(5000)))>0){
                System.out.println("created a new file: "+fileName);
                directoryChanged=true;
                continue;
            }
            if (file.getLastModifiedTime().compareTo(FileTime.from(Instant.now().minusMillis(5000)))>0) {
                System.out.println("the file "+fileName +" was changed");
                directoryChanged=true;
            }

        }

    }
    public void printInfo(String fileName) throws IOException {
        FileInfo fileInfo=new FileInfo(DIRECTORY_PATH+"/"+fileName);
        switch (fileInfo.getExtension()){
            case "png","jpg" -> {
                ImageInfo imageInfo = new ImageInfo(DIRECTORY_PATH+"/"+fileName);
                imageInfo.printInfo();
            }
            case "txt"-> {
                TextInfo textInfo = new TextInfo(DIRECTORY_PATH+"/"+fileName);
                textInfo.printInfo();
            }
            case "py", "java" ->{
                ProgramInfo programInfo = new ProgramInfo(DIRECTORY_PATH+"/"+fileName);
                programInfo.printInfo();
            }
        }
    }


    public static FileTime getLastCommit() {
        return lastCommit;
    }
}

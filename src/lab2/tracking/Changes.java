//package lab2.tracking;
//
//import lab2.fileinfo.FileInfo;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.attribute.FileTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Changes {
//     final String DIRECTORY_PATH="src/lab1/operations";
//     final Set<String> FILE_NAMES;
//     static FileTime lastCommit;
//
//    public Changes() {
//        this.FILE_NAMES = Stream.of(Objects.requireNonNull(new File(DIRECTORY_PATH).listFiles()))
//                .filter(file -> !file.isDirectory())
//                .map(File::getName)
//                .collect(Collectors.toSet());
//
//    }
//
//
//    public void status() throws IOException {
//        List<FileInfo> files = new ArrayList<>();
//        FileInfo file;
//        boolean directoryChanged=false;
//        for (String fileName:
//                FILE_NAMES) {
//            file = new FileInfo(DIRECTORY_PATH+"/"+fileName);
//            files.add(file);
//            if (file.getCreationTime().compareTo(lastCommit)>0){
//                System.out.println("SINCE LAST COMMIT CREATED FILE "+fileName);
//                directoryChanged=true;
//                continue;
//            }
//            if (file.getLastModifiedTime().compareTo(lastCommit)>0) {
//                System.out.println("SINCE LAST COMMIT THE FILE "+fileName +" WAS CHANGED");
//                directoryChanged=true;
//            }
//
//        }
//        if (!directoryChanged) System.out.println("No changes since last commit");
//
//    }
//}

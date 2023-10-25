//package lab2.tracking;
//
//import java.io.File;
//import java.time.LocalDateTime;
//import java.util.Objects;
//import java.util.Set;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class Tracking {
//    LocalDateTime lastCommit;
//    private Set<String> files;
//    public Tracking(String classpath){
//        this.files=Stream.of(Objects.requireNonNull(new File(classpath).listFiles()))
//                .filter(file -> !file.isDirectory())
//                .map(File::getName)
//                .collect(Collectors.toSet());
//    }
//
//    public Set<String> listFiles(String dir) {
//        return Stream.of(new File(dir).listFiles())
//                .filter(file -> !file.isDirectory())
//                .map(File::getName)
//                .collect(Collectors.toSet());
//    }
//
//    void commit(){
//        this.lastCommit=LocalDateTime.now();
//    };
//    void getChangedFiles(){
//
//    };
//
//}

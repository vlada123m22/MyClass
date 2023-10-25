//package lab2.tracking;
//
//
//import lab2.fileinfo.ProgramInfo;
//
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.Hashtable;
//import java.util.List;
//
//public class SnapshotSystem {
//  private final String DIRECTORY_PATH;
//  private final String SNAPSHOT_FILE;
//
//  private final Hashtable<String, ProgramInfo> currentSnapshot;
//  private Hashtable<String, ProgramInfo> lastKnownSnapshot;
//  private Hashtable<String, ProgramInfo> previousSnapshot;
//  private long lastSnapshotTime;
//
//  public SnapshotSystem(String directoryPath, String snapshotFile) {
//    this.DIRECTORY_PATH = directoryPath;
//    this.SNAPSHOT_FILE = snapshotFile;
//    this.currentSnapshot = new Hashtable<>();
//    this.previousSnapshot = new Hashtable<>();
//    this.lastKnownSnapshot = new Hashtable<>(this.currentSnapshot);
//  }
//
//  public void loadSnapshot() {
//    loadPreviousSnapshot();
//    loadCurrentSnapshot();
//  }
//
//  public void loadPreviousSnapshot() {
//    try {
//      List<String> lines = Files.readAllLines(Paths.get(SNAPSHOT_FILE));
//      lastSnapshotTime = Long.parseLong(lines.get(0));
//
//      previousSnapshot.clear();
//      for (int i = 1; i < lines.size(); i++) {
//        String[] parts = lines.get(i).split(",");
//        String fileName = parts[0];
//        File file = new File(DIRECTORY_PATH + fileName);
//        long lastModified = file.exists() ? Long.parseLong(parts[1]) : 0;
//        ProgramInfo fileObj ;
//        previousSnapshot.put(fileName, fileObj);
//      }
//    } catch (IOException e) {
//      System.out.println("Failed to load snapshot or snapshot doesn't exist");
//    }
//  }
//
//  public void loadCurrentSnapshot() {
//    currentSnapshot.clear();
//    File directory = new File(DIRECTORY_PATH);
//    if (directory.exists() && directory.isDirectory()) {
//      File[] files = directory.listFiles();
//      if (files != null) {
//        for (File file : files) {
//          String fileName = file.getName();
//          SystemFile fileObj = SystemFile.createFileObject(DIRECTORY_PATH, fileName, file.lastModified());
//          currentSnapshot.put(fileName, fileObj);
//        }
//      }
//    }
//  }
//
//  public void saveSnapshot() {
//    try (PrintWriter writer = new PrintWriter(SNAPSHOT_FILE)) {
//      writer.println(lastSnapshotTime);
//      for (String fileName : previousSnapshot.keySet()) {
//        File file = new File(DIRECTORY_PATH + fileName);
//        writer.println(fileName + "," + file.lastModified());
//      }
//      System.out.println("Snapshot saved to .snapshot.txt.");
//    } catch (IOException e) {
//      System.out.println("Failed to save snapshot: " + e.getMessage());
//    }
//  }
//
//  public Hashtable<String, SystemFile> getCurrentSnapshot() {
//    return currentSnapshot;
//  }
//
//  public Hashtable<String, SystemFile> getPreviousSnapshot() {
//    return previousSnapshot;
//  }
//
//  public long getLastSnapshotTime() {
//    return lastSnapshotTime;
//  }
//
//  public Hashtable<String, SystemFile> getLastKnownSnapshot() {
//    return lastKnownSnapshot;
//  }
//
//  public void setLastSnapshotTime(long lastSnapshotTime) {
//    this.lastSnapshotTime = lastSnapshotTime;
//  }
//
//  public void setCurrentSnapshot(Hashtable<String, SystemFile> currentSnapshot) {
//    this.currentSnapshot.clear();
//    this.currentSnapshot.putAll(currentSnapshot);
//  }
//
//  public void setPreviousSnapshot(Hashtable<String, SystemFile> previousSnapshot) {
//    this.previousSnapshot.clear();
//    this.previousSnapshot.putAll(previousSnapshot);
//  }
//
//  public void setLastKnownSnapshot() {
//    this.lastKnownSnapshot.clear();
//    this.lastKnownSnapshot.putAll(this.currentSnapshot);
//  }
//}

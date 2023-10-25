package lab2.fileinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramInfo extends FileInfo{

    private int lineCount;
    private int classCount;
    private int methodCount;
    public ProgramInfo(String filePath) throws IOException {
        super(filePath);
        this.parseProgramFile();
    }

    private void parseProgramFile() {
        File file = new File(getFilePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;

                Pattern classPattern, methodPattern;
                Matcher classMatcher, methodMatcher;

                if (getExtension().equals("py")) {
                    classPattern = Pattern.compile("^class\\s+\\w+:");
                    methodPattern = Pattern.compile("^def\\s+\\w+\\(.*\\):");
                } else if (getExtension().equals("java")) {
                    classPattern = Pattern.compile("\\bclass\\b");
                    methodPattern = Pattern
                            .compile("^(public|private|protected|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+[\\w_]+\\(.*\\)\\s*\\{?$");
                } else {
                    continue;
                }

                classMatcher = classPattern.matcher(line.trim());
                methodMatcher = methodPattern.matcher(line.trim());
                if (classMatcher.find())
                    classCount++;
                if (methodMatcher.find())
                    methodCount++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLineCount() {
        return lineCount;
    }

    public int getClassCount() {
        return classCount;
    }


    public int getMethodCount() {
        return methodCount;
    }

    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Line count: " + lineCount);
        System.out.println("Class count: " + classCount);
        System.out.println("Method count: " + methodCount);
    }

}

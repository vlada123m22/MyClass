package lab2.fileinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TextInfo extends FileInfo{
    private int lineCount;
    private int wordCount;
    private int charCount;
    public TextInfo(String filePath) throws IOException {
        super(filePath);
        this.computeTextFileAttributes();
    }

    private void computeTextFileAttributes() {
        File file = new File(this.getFilePath());
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                this.lineCount++;
                this.charCount += line.length();

                String[] words = line.split("\\s+");
                this.wordCount += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getLineCount() {
        return lineCount;
    }


    public int getWordCount() {
        return wordCount;
    }


    public int getCharCount() {
        return charCount;
    }
    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Line Count: " + lineCount);
        System.out.println("Word Count: " + wordCount);
        System.out.println("Character Count: " + charCount);
    }

}

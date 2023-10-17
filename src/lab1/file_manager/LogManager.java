package lab1.file_manager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class LogManager{

    public void addLog(String opperation, File file) throws IOException {
        FileWriter writer=new FileWriter(file, true);
        Date currentDate=new Date();
        writer.write(opperation+"                      " +currentDate.toString()+"\n");
        writer.close();
    }
}

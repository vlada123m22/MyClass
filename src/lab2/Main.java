package lab2;

import lab2.tracking.ApplicationLoop;
import lab2.tracking.DetectionFlow;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        ApplicationLoop applicationLoop =new ApplicationLoop();
        System.out.println(ApplicationLoop.MESSAGE);
        DetectionFlow detectionFlow = new DetectionFlow();
        detectionFlow.setPriority(Thread.MAX_PRIORITY);
        applicationLoop.setPriority(Thread.MIN_PRIORITY);
        applicationLoop.start();
        detectionFlow.start();


   }
}

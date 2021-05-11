package ss04_class_and_object_in_java.exercise.StopWatch;

import java.util.Date;

public class StopWatch {
    private double starTime, endTime;

    public void starTime() {
        Date now = new Date();
        this.starTime = now.getTime();
        System.out.println("Date now: " + now);
    }

    public void endTime() {
        Date now = new Date();
        this.endTime = now.getTime();
        System.out.println("Date now: " + now);
    }

    public double getElapsedTime() {
        return this.endTime - this.starTime;
    }
}

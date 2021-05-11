package ss04_class_and_object_in_java.exercise.StopWatch;

public class RunStopWatch {
    public static void main(String[] args) {
        StopWatch date = new StopWatch();
        date.starTime();
        int[] array = new int[100000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (100000000 + 1));
        }
        date.endTime();
        System.out.print("\n" + "Time elapsed: " + date.getElapsedTime() + " milliseconds.");
    }
}


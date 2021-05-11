package ss04_class_and_object_in_java.exercise.Fan;

public class RunFan {
    public static void main(String[] args) {
        Fan fan = new Fan();
        Fan fan1 = new Fan(true, Fan.FAST, 10, "yellow");
        Fan fan2 = new Fan(false, Fan.MEDIUM, 5, "blue");
        System.out.println(fan.toString() + "\n" + fan1.toString() + "\n" + fan2.toString());
    }
}

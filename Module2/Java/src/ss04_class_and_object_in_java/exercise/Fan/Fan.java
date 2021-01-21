package ss04_class_and_object_in_java.exercise.Fan;

public class Fan {
    private boolean on;
    private int speed, radius;
    private String color;
    public static final int SlOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    public Fan(boolean on, int speed, int radius, String color) {
        this.on = on;
        this.speed = speed;
        this.radius = radius;
        this.color = color;
    }

    public Fan() {
        this(false, SlOW, 5, "blue");
    }

    public boolean getOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (on) {
            return "Fan { speed=" + speed +
                    " radius=" + radius + ", color='" + color + '\'' +
                    '}' + " Fan is on";
        } else return "Fan{ radius=" + radius + ", color='" + color + '\'' +
                '}' + " Fan is off";

    }
}

package ss06_Inheritance.exercise.circle_and_cylinder;

public class Cylinder extends Circle {
    private double high;

    public Cylinder(double high, double radius, String color) {
        super(radius, color);
        this.high = high;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    @Override
    public String toString() {
        return "Cylinder{" + "radius: " + getRadius() +
                ", color: " + getColor() +
                ", high=" + high +
                '}';
    }

    public double getArea() {
        return (2 * Math.PI * getRadius() * getHigh() + 2 * Math.PI * Math.pow(getRadius(), 2));
    }

    public double getVolume() {
        return (high * Math.PI * Math.pow(getRadius(), 2));
    }

    public static void main(String[] args) {
        Cylinder cylinder = new Cylinder(7.7, 5, "Yellow");
        System.out.println(cylinder.toString() + "\n" +
                "Area: " + cylinder.getArea() + "\n" +
                "Volume: " + cylinder.getVolume());
    }
}

package ss06_Inheritance.exercise.circle_and_cylinder;

public class Circle {

    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
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
        return "Circle{" +
                "radius=" + getRadius() +
                ", color='" + getColor() + '\'' +
                '}';
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(5, "red");
        System.out.println(circle.toString() + "\n" +
                "Perimeter: " + circle.getPerimeter() + "\n" +
                "Area: " + circle.getArea());
    }
}

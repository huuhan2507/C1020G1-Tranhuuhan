package ss07_abstract_class_and_interface.exercise.interface_resizeable;

public class Circle extends Shape implements Resizeable {
    private double radius;

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
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
                "radius=" + radius +
                ", color='" + color + "\t" + "Area: " + getArea() +
                '}';
    }

    public double getArea() {
        return 2 * Math.PI * radius * radius;
    }

    @Override
    public void resize(double percent) {
        this.radius = this.radius * (1 + percent / 100);
    }
}

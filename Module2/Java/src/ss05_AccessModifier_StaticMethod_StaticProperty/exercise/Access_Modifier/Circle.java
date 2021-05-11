package ss05_AccessModifier_StaticMethod_StaticProperty.exercise.Access_Modifier;

public class Circle {
    private double radius;
    private String color;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + getRadius() +
                ", area=" + getArea() +
                ", color='" + getColor() + '\'' +
                '}';
    }
}

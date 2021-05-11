package ss07_abstract_class_and_interface.exercise.interface_colorable;

public class Shape {
    public String color;

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Shape{" +
                "color='" + this.color + '\'' +
                '}';
    }
}

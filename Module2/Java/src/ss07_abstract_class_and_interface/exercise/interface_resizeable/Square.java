package ss07_abstract_class_and_interface.exercise.interface_resizeable;

public class Square extends Shape implements Resizeable {
    private double side;

    public Square(String color, double side) {
        super(color);
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Square{" +
                "side= " + side + "\t" +
                ", color= " + color + "\t" + "Area: " + getArea() +
                '}';
    }

    public double getArea() {
        return side * side;
    }

    @Override
    public void resize(double percent) {
        this.side = this.side * (1 + percent / 100);
    }
}

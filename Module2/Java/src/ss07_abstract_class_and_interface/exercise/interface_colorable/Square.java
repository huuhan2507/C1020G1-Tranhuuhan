package ss07_abstract_class_and_interface.exercise.interface_colorable;

public class Square extends Shape implements Colorable {
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

    public Square(String color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Square{" +
                "side=" + side +
                ", color: " + getColor() +
                '}';
    }

    @Override
    public void howToColor() {
        System.out.println(getColor()+" all four sides");
    }
}

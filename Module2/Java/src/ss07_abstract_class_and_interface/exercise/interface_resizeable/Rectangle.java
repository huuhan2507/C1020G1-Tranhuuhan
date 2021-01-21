package ss07_abstract_class_and_interface.exercise.interface_resizeable;

public class Rectangle extends Shape implements Resizeable {
    private double side1, side2;

    public Rectangle(String color, double side1, double side2) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
    }

    public double getSide1() {
        return side1;
    }

    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public double getSide2() {
        return side2;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                " side1= " + side1 +
                ", side2= " + side2 +
                ", color= " + color + "\t" + "Area: " + getArea()+
                '}';
    }
    public double getArea(){
        return side1*side2;
    }

    @Override
    public void resize(double percent) {
        this.side1=this.side1*(1+percent/100);
        this.side2=this.side2*(1+percent/100);
    }
}

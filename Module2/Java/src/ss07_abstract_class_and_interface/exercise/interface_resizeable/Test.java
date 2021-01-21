package ss07_abstract_class_and_interface.exercise.interface_resizeable;


public class Test {
    public static void main(String[] args) {
        double percent = Math.floor(Math.random() * 100);
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle("red", 5.6);
        shapes[1] = new Rectangle("yellow", 7, 5);
        shapes[2] = new Square("red", 6);
        System.out.println("Pre-sorted:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("After-sorted:");
        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                Circle circle = (Circle) shape;
                circle.resize(percent);
                System.out.println(circle);
            }
            if (shape instanceof Rectangle) {
                Rectangle rectangle = (Rectangle)shape;
                rectangle.resize(percent);
                System.out.println(rectangle);
            }
            if (shape instanceof Square) {
                Square square = (Square) shape;
                square.resize(percent);
                System.out.println(square);
            }
        }

    }
}

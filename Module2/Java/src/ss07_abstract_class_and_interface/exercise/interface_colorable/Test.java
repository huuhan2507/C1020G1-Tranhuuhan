package ss07_abstract_class_and_interface.exercise.interface_colorable;

public class Test {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];
        shapes[0] = new Circle("red", 3.5);
        shapes[2] = new Rectangle("yellow", 5, 3);
        shapes[1] = new Square("blue", 6);
        shapes[3] = new Square("pink", 3);
        shapes[4] = new Square("cyan", 9);
        System.out.println("Pre-sorted:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("After-sorted:");

        for (Shape shape : shapes) {
            if (shape instanceof Square) {
                Square square = (Square) shape;
                System.out.println(shape);
                square.howToColor();
            } else System.out.println(shape);
        }
    }
}

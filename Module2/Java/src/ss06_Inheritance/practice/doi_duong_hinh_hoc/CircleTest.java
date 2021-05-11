package ss06_Inheritance.practice.doi_duong_hinh_hoc;

public class CircleTest {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle + "\n" +
                "Perimeter: " + circle.getPerimeter() + "\n" +
                "Area: " + circle.getArea());


        circle = new Circle(3.5);
        System.out.println(circle + "\n" +
                "Perimeter: " + circle.getPerimeter() + "\n" +
                "Area: " + circle.getArea());

        circle = new Circle(5, "indigo", false);
        System.out.println(circle + "\n" +
                "Perimeter: " + circle.getPerimeter() + "\n" +
                "Area: " + circle.getArea());
    }
}

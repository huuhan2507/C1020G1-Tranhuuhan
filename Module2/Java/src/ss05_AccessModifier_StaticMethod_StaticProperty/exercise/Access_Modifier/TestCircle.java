package ss05_AccessModifier_StaticMethod_StaticProperty.exercise.Access_Modifier;

import java.util.Scanner;

public class TestCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Circle circle = new Circle(1.0,"red");
        System.out.println(circle.toString());
        Circle circle1 = new Circle(3.0, "yellow");
        System.out.println("Enter new color : ");
        String colorCircle = scanner.nextLine();
        circle1.setColor(colorCircle);
        System.out.println("Enter radius new circle: ");
        double radiusCircle = scanner.nextDouble();
        circle1.setRadius(radiusCircle);
        System.out.println(circle1.toString());
    }
}

package ss06_Inheritance.exercise.Triangle;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        System.out.println(triangle.toString());
        System.out.println();

        Triangle triangle1 = new Triangle("yellow", true, 5, 6, 7);
        System.out.println(triangle1.toString());
        System.out.println();

        System.out.println("Enter color: ");
        String color = scanner.nextLine();

        System.out.println("Filled: ");
        boolean filled = scanner.hasNext();

        boolean check ;
        double side1, side2, side3;
        do {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Enter side1: ");
            side1 = scanner1.nextDouble();
            System.out.println("Enter side2: ");
            side2 = scanner1.nextDouble();
            System.out.println("Enter side3: ");
            side3 = scanner1.nextDouble();
            if ((side1 + side2 < side3) || (side1 + side3 < side2) || (side2 + side3 < side1)) {
                System.out.println("Re-enter");
                check = true;
            }else check=false;
        } while (check);
        Triangle triangle2 = new Triangle(color, filled, side1, side2, side3);
        System.out.println(triangle2.toString());
    }
}

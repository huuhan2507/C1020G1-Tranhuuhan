package ss08_clean_code_and_refactoring.practice;

import java.util.Scanner;

public class Cylinder {
    public static double getVolume(int radius, int height) {
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        return perimeter * height + 2 * baseArea;
    }

    private static double getPerimeter(int radius) {
        return 2 * Math.PI * radius;
    }

    private static double getBaseArea(int radius) {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter radius: ");
        int radius = scanner.nextInt();
        System.out.println("Enter height: ");
        int height = scanner.nextInt();
        System.out.println("Area: " + getBaseArea(radius));
        System.out.println();
        System.out.println("Perimeter: " + getPerimeter(radius));
        System.out.println();
        System.out.println("Volume: " + getVolume(radius, height));
    }
}

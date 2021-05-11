package ss15_exception_and_debug.exercise;

import java.util.Scanner;

public class IllegalTriangle {

    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter side a: " );
        int sideA = scanner.nextInt();
        System.out.println( "Enter side b: " );
        int sideB = scanner.nextInt();
        System.out.println( "Enter side c: " );
        int sideC = scanner.nextInt();
        try {
            new Triangle( sideA, sideB, sideC );
        } catch (IllegalTriangleException e) {
            e.printStackTrace();
        }
    }
}

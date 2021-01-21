package ss09_automated_testing_and_tdd.practice.absolute_value;

import java.util.Scanner;

public class AbsoluteValue {
    public static double Absolute(double firstNumber) {
        if (firstNumber >= 0) {
            return firstNumber;
        } else return -firstNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        double firstNumber = scanner.nextDouble();
        System.out.println("Number after absolute: ");
        System.out.println(Absolute(firstNumber));
    }
}

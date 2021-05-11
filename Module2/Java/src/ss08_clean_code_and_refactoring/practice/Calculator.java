package ss08_clean_code_and_refactoring.practice;

import java.util.Scanner;

public class Calculator {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';

    public static int calculate(int firstOperand, int secondOperand, char operator) {
        switch (operator) {
            case ADDITION:
                return firstOperand + secondOperand;
            case SUBTRACTION:
                return firstOperand - secondOperand;
            case MULTIPLICATION:
                return firstOperand * secondOperand;
            case DIVISION:
                if (secondOperand != 0)
                    return firstOperand / secondOperand;
                else
                    throw new RuntimeException("Can not divide by 0");
            default:
                throw new RuntimeException("Unsupported operation");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int firstOperand = scanner.nextInt();
        System.out.println("Enter number 2: ");
        int secondOperand = scanner.nextInt();
        System.out.println("Enter calculation: ");
        char operator = scanner.next().charAt(0);
        System.out.println("result: " + calculate(firstOperand, secondOperand, operator));

    }
}

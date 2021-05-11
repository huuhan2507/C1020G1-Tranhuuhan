package ss09_automated_testing_and_tdd.exercise.nextday;

import java.util.Scanner;

public class NextDayCalculatorTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter day: ");
        int day = scanner.nextInt();
        System.out.println("Enter month");
        int month = scanner.nextInt();
        System.out.println("Enter year: ");
        int year = scanner.nextInt();
        NextDayCalculator.nextDay(day, month, year);
        NextDayCalculator.nextAfterDay(day, month, year);
    }
}

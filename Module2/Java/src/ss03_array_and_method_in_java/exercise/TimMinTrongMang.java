package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class TimMinTrongMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of Array: ");
        int n = scanner.nextInt();
        String result = "";
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter value of element " + (i + 1) + " :");
            array[i] = scanner.nextInt();
            result += array[i] + "\t";
        }
        System.out.println("All Element of Array is: " + "\n" + result);
        int min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        System.out.println("Value min of Array is: " + min);
    }
}

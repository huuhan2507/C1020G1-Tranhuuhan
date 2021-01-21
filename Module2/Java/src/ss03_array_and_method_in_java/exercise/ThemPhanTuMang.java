package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class ThemPhanTuMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        String result = "";
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + " of A:");
            array[i] = scanner.nextInt();
            result += array[i] + "\t";
        }
        System.out.println("Element of array is: " + "\n" + result);

        int[] array1 = new int[array.length + 1];

        System.out.println("Enter Value Element of Array: ");
        int number = scanner.nextInt();

        System.out.println("Enter index of Element: ");
        int index = scanner.nextInt();
        if (index < 1 || index > array1.length) {
            System.out.println("Don't add: ");
        } else for (int i = 0; i < index - 1; i++) {
            array1[i] = array[i];
        }
        array1[index - 1] = number;
        for (int i = array1.length - 1; i > index - 1; i--) {
            array1[i] = array[i - 1];
        }
        System.out.println("Element of array after add: ");
        for (int i = 0; i < array1.length; i++) {
            System.out.print(array1[i] + "\t");
        }

    }
}

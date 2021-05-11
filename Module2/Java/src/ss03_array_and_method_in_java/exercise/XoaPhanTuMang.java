package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class XoaPhanTuMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = {1, 2, 3, 4, 5, 6, 7, 6, 9};
        System.out.println("Enter element of array want delete: ");
        int number = scanner.nextInt();
        int index;
        for (int i = 0; i < array.length; i++) {
            if (number == array[i]) {
                index = i;
                for (int j = index; j < array.length - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}

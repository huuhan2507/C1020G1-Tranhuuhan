package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class TimMaxMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter row: ");
        int n = scanner.nextInt();
        System.out.println("Enter column: ");
        int m = scanner.nextInt();
        int[][] array = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("Enter element a[" + i + "][" + j + "] :");
                array[i][j] = scanner.nextInt();
            }
        }
        int max = array[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
        }
        System.out.println("Max in Multidimensional Arrays is: " + max);

    }
}

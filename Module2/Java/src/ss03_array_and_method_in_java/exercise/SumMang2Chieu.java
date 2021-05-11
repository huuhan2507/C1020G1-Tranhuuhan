package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class SumMang2Chieu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arrayA = {{3, 4, 7, 9}, {3, 5, 2, 7}, {4, 5, 7, 9}, {1, 3, 5, 2, 5}};

        boolean check = true;
        int sum = 0;
        do {
            System.out.println("What column do you want to sum? ");
            int column = scanner.nextInt() - 1;
            if (column < 0 || column > 3) {
                System.out.println("Re-Enter");
                check = true;
            } else {
                for (int i = 0; i < arrayA[column].length; i++) {
                    sum += arrayA[column][i];
                }
                System.out.println("the sum of the column you just entered is: " + sum);
                check = false;
            }


        } while (check);
    }
}

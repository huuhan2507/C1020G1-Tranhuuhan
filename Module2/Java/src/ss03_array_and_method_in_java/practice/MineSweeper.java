package ss03_array_and_method_in_java.practice;

import java.util.Scanner;

public class MineSweeper {
    public static String[][] insertMatrix(String[][] matrix, int x, int y) {
        int count = 0;
        if (x > 0 && x < matrix[0].length - 1) {
            if (matrix[y][x - 1].equals("*")) {
                count++;
            }
            if (matrix[y][x + 1].equals("*")) {
                count++;
            }
            if (y > 0 && y < matrix.length - 1) {
                if (matrix[y + 1][x + 1].equals("*")) {
                    count++;
                }
                if (matrix[y + 1][x - 1].equals("*")) {
                    count++;
                }
                if (matrix[y - 1][x + 1].equals("*")) {
                    count++;
                }
                if (matrix[y - 1][x - 1].equals("*")) {
                    count++;
                }
            }
        } else if (x == matrix[0].length - 1) {
            if (matrix[y][x - 1].equals("*")) {
                count++;
            }
        } else if (x == 0) {
            if (matrix[y][x + 1].equals("*")) {
                count++;
            }
        }
        if (y > 0 && y < matrix.length - 1) {
            if (matrix[y + 1][x].equals("*")) {
                count++;
            }
            if (matrix[y - 1][x].equals("*")) {
                count++;
            }
        } else if (y == matrix.length - 1) {
            if (matrix[y - 1][x].equals("*")) {
                count++;
            }
        } else if (y == 0) {
            if (matrix[y + 1][x].equals("*")) {
                count++;
            }
        }
        matrix[y][x] = count + "";
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String map[][] = {
                {".", ".", "*", "."},
                {"*", ".", ".", "."},
                {".", ".", ".", "*"},
                {"*", ".", ".", "."}
        };
        int choose;
        for (String[] arr : map) {
            for (String element : arr) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
        do {
            System.out.println("Nhập X(theo phương ngang 0 -> 3)");
            int xPosition = scanner.nextInt();
            System.out.println("Nhập Y(theo phương thẳng đứng 0 -> 3)");
            int yPosition = scanner.nextInt();
            if (map[yPosition][xPosition].equals("*")) {
                System.out.println("You Lose");
            } else {
                map = insertMatrix(map, xPosition, yPosition);
            }
            for (String[] arr : map) {
                for (String element : arr) {
                    System.out.print(element + "\t");
                }
                System.out.println();
            }
            System.out.println("Bạn có muốn tiếp tục ?\n Nhập số bất kì để tiếp tục hoặc 0 để thoát!");
            choose = scanner.nextInt();
        } while (choose != 0);
    }
}

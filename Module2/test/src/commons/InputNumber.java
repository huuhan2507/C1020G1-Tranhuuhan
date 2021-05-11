package commons;

import java.util.Scanner;

public class InputNumber {
    public static int input(){
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Lam on, hay nhap so !");
            }
        } while (true);
        return number;
    }
}

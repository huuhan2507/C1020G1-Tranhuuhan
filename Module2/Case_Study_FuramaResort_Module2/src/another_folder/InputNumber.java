package another_folder;

import java.util.Scanner;

public class InputNumber {
    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        int number;
        do {
            try {
                number = Integer.parseInt(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.err.println("Please Enter a Number!");
            }
        } while (true);
        return number;
    }

}

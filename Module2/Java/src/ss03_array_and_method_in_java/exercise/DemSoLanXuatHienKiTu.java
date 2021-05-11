package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class DemSoLanXuatHienKiTu {
    public static void main(String[] args) {
        String str = "qwertyuiopasdfghjklzxcvbnmjadhdqoiwqmzx1231398149540923123456789021411141240";
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int count = 0;
        System.out.println("Enter characters: ");
        char character = scanner.next().charAt(0);
        for (int i = 0; i < str.length(); i++) {
            if (character == str.charAt(i)) {
                count++;
            }
        }
        System.out.println("The number of occurrences of characters entered is: " + count);

    }
}

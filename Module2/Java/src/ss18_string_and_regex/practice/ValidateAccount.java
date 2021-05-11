package ss18_string_and_regex.practice;

import java.util.Scanner;

public class ValidateAccount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter account: ");
        String account= scanner.nextLine();
        String regexAccount= "^[\\w_]{6,}$";
        if (account.matches( regexAccount )){
            System.out.println("Account valid");
        }else {
            System.err.println("Account invalid");
        }
    }
}

package ss18_string_and_regex.practice;

import java.util.Scanner;

public class ValidateEmail {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println("Enter email: ");
        String email = scanner.nextLine();
        String regexEmail="\\w+@[a-zA-z]+(\\.\\w+)$";
        if (email.matches( regexEmail )){
            System.out.println("Email valid");
        }else {
            System.err.println("Email invalid");
        }
    }
}

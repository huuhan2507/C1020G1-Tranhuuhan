package ss11_dsa_queue_stack.exercise;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class PalindromeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner( System.in );
        System.out.println( "Enter your string: " );
        String string = input.nextLine();
        if (isPalindrome( string )) {
            System.out.println( "This is palindrome" );
        } else {
            System.out.println( "This is not palindrome" );
        }
    }

    public static boolean isPalindrome(String string) {
        Stack<Character> stack = new Stack<>();
        Deque<Character> queue = new LinkedList<>();
        boolean isPalindrome = false;
        for (int i = 0; i < string.length(); i++) {
            stack.push( string.charAt( i ) );
            queue.add( string.charAt( i ) );
        }
        while (!stack.isEmpty()) {
            if (stack.pop()== queue.poll() ) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }
}

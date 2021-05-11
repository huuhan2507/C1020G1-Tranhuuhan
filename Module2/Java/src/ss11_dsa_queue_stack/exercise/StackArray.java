package ss11_dsa_queue_stack.exercise;

import java.util.Scanner;
import java.util.Stack;

public class StackArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter element number to array:  " );
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            System.out.println( "Enter element " + (i + 1) + " : " );
            int element = scanner.nextInt();
            stack.push( element );
        }
        int size = stack.size();
        System.out.println( "Array before: " );
        System.out.println( stack );
        int[] temp = new int[size];
        for (int i = 0; i < size; i++) {
            temp[i] = stack.pop();
        }
        for (int i = 0; i < size; i++) {
            stack.push( temp[i] );
        }
        System.out.println( "Array after: " );
        System.out.println( stack );
    }
}

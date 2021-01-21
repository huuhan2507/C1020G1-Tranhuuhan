package ss11_dsa_queue_stack.exercise;

import java.util.Scanner;
import java.util.Stack;

public class StackString {
    public static void main(String[] args) {
        Scanner scanner= new Scanner( System.in );
        System.out.println("Enter String: ");
        String string= scanner.nextLine();
        Stack<String> stack=new Stack<>();
        System.out.println(string);
        String[] array=string.split( "" );
        for (int i=0;i<array.length;i++){
            stack.push( array[i] );
        }
        String fullString="";
        for (int i=0;i<array.length;i++){
            fullString+=stack.pop();
        }
        System.out.println(fullString);
    }
}

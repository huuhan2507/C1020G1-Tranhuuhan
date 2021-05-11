package ss11_dsa_queue_stack.exercise;

import java.util.Scanner;
import java.util.TreeMap;


public class CharTreeMap {
    public static void main(String[] args) {
        Scanner scanner = new Scanner( System.in );
        System.out.println( "Enter string: " );
        String string = scanner.nextLine().toLowerCase();
        String[] array = string.split( "" );
        TreeMap<Character, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < array.length; i++) {
            char temp = string.charAt( i );
            Integer count = treeMap.get( temp );
            System.out.println(count);
            if (count == null) {
                treeMap.put( temp, 1 );
            } else {
                count++;
                treeMap.put( temp, count );
            }
        }
        treeMap.forEach( (key, value) -> System.out.println( key + " appear " + value ) );
    }
}

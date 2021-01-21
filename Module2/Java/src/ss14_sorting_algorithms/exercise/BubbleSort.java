package ss14_sorting_algorithms.exercise;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] list) {
        boolean needNextPass = true;
        int count = 1;
        for (int k = 1; k < list.length && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < list.length - k; i++) {
                if (list[i] > list[i + 1]) {
                    System.out.println( "Step " + count + ": Swap " + list[i] + " with " + list[i + 1] );
                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    System.out.println( "Array after swap " + Arrays.toString( list ) );
                    needNextPass = true;
                    count++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] list = {1, 9, -4, 3, 6, -2, 7, 13, 8, 5};
        System.out.println( "Array before Sort:" );
        System.out.println( Arrays.toString( list ) );
        System.out.println( "-----------------------------------" );
        bubbleSort( list );
        System.out.println( "------------------------------------" );
        System.out.println( "Array after Sort:" );
        System.out.println( Arrays.toString( list ) );
    }
}

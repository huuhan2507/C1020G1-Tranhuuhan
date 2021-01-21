package ss14_sorting_algorithms.exercise;

public class InsertSort {
//    public static void insertionSort(int[] list) {
//        int currentElement;
//        int count = 1;
//        for (int i = 1; i < list.length; i++) {
//            System.out.println( "Step" + count );
//            System.out.println( "Current Element = " + list[i] );
//            currentElement = list[i];
//            int k;
//            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
//                System.out.println( "Compare " + list[k] + " with " + currentElement );
//                list[k + 1] = list[k];
//            }
//            System.out.println( "K = " + k );
//            list[k + 1] = currentElement;
//            System.out.println( "Array is inserted after compare: " + Arrays.toString( list ) );
//            System.out.println();
//            count++;
//        }
//    }

//    public static void main(String[] args) {
//        System.out.println( "Array before sorting: " );
//        int[] list = {1, 9, 4, -2, 7, 6, 14, 12, 0};
//        System.out.println( Arrays.toString( list ) );
//        System.out.println( "-----------------------------------------------" );
//        insertionSort( list );
//        System.out.println( "-----------------------------------------------" );
//        System.out.println( "Array after sorting: " );
//        System.out.println( Arrays.toString( list ) );
//    }
public static void main(String[] args) {

    try {
        int x = 0;
        int y = 5 / x;
    } catch (ArithmeticException e) {
        System.out.println( "Arithmetic" );
    } catch (Exception ae) {
        System.out.println( "Exception" );
    }
    System.out.println( "finished" );
}
}

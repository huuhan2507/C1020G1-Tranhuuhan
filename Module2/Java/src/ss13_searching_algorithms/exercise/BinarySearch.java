package ss13_searching_algorithms.exercise;

public class BinarySearch {
    int binarySearch(int[] array, int x, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if (array[mid] == x)
                return mid;
            if (array[mid] > x) return binarySearch( array, x, low, mid - 1 );
            return binarySearch( array, x, mid + 1, high );
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch binarySearch = new BinarySearch();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};
        int n = array.length / 2;
        int x = 4;
        int result = binarySearch.binarySearch( array, x, 0, n - 1 );
        if (result == -1)
            System.out.println( "Not found" );
        else
            System.out.println( "Element found at index " + result );
    }
}


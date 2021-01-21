package ss03_array_and_method_in_java.practice;

public class MinValue {
    public static int minValue(int[] arr){
        int min=arr[0];
        int indexMin=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]<min){
                min=arr[i];
                indexMin=i;
            }
        }
        return indexMin;
    }
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 6, 6, 9};
        int index = minValue(arr);
        System.out.println("The smallest element in the array is: " + arr[index]);
    }
}
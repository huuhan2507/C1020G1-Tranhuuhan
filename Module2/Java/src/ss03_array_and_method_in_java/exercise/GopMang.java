package ss03_array_and_method_in_java.exercise;

        import java.util.Scanner;

public class GopMang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of array A: ");
        int n = scanner.nextInt();
        int[] arrayA = new int[n];
        String result = "";
        for (int i = 0; i < n; i++) {
            System.out.println("Enter element " + (i + 1) + " of A:");
            arrayA[i] = scanner.nextInt();
            result += arrayA[i] + "\t";
        }
        System.out.println("Enter number of array B: ");
        int n1 = scanner.nextInt();
        int[] arrayB = new int[n1];
        String result1 = "";
        for (int i = 0; i < n1; i++) {
            System.out.println("Enter element " + (i + 1) + " of B:");
            arrayB[i] = scanner.nextInt();
            result1 += arrayB[i] + "\t";
        }
        System.out.println("Element of array A is: " + "\n" + result);
        System.out.println("Element of array B is: " + "\n" + result1);

        int[] arrayC = new int[arrayA.length + arrayB.length];
        for (int i = 0; i < arrayA.length; i++) {
            arrayC[i] = arrayA[i];
        }
        for (int i = arrayA.length; i < arrayC.length; i++) {
            arrayC[i] = arrayB[i - arrayA.length];
        }
        String temp = "";
        for (int i = 0; i < arrayC.length; i++) {
            temp += arrayC[i] + "\t";
        }
        System.out.println("Element of array C is :" + "\n" + temp);
    }


}

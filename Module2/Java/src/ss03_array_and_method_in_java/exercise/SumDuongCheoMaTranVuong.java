package ss03_array_and_method_in_java.exercise;

import java.util.Scanner;

public class SumDuongCheoMaTranVuong {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        boolean check;
        int sum=0;
        do {
            System.out.println("Enter the column and row number of the array: ");
            int number=scanner.nextInt();
            if (number<=0){
                System.out.println("Re-Enter");
                check=true;
            }else {
                int[][] array=new int[number][number];
                for (int i=0;i<number;i++){
                    for (int j=0;j<number;j++){
                        System.out.println("Enter element +array["+i+"]["+j+"]: ");
                        array[i][j]=scanner.nextInt();
                    }
                }
                for (int i=0;i<number;i++){
                    sum+=array[i][i];
                }
                System.out.println("The sum of the diagonal values of the array you just entered is: "+sum);
                check=false;
            }
        }while (check);

    }
}

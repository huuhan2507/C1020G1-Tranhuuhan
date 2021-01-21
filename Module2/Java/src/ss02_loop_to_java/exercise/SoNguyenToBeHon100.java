package ss02_loop_to_java.exercise;

public class SoNguyenToBeHon100 {
    public static void main(String[] args) {
        int number = 2;
        boolean check = true;
        String result = "";
        while (number < 100) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                }
                check=true;
            }
            if (check) {
                result += number + "\t";
            }
            number++;
        }
        System.out.println(result);
    }
}

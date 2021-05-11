package ss02_loop_to_java.exercise;

public class In20SoNguyenTo {
    public static void main(String[] args) {
        int number = 2;
        String result = "";
        int count = 0;
        while (count < 20) {
            boolean check = true;
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    check = false;
                    break;
                } else check = true;
            }
            if (check) {
                result += number + "\t";
                count++;
            }
            number++;
        }
        System.out.println(result);
    }
}

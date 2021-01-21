package ss08_clean_code_and_refactoring.practice;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        boolean isFizz = number % 3 == 0;
        boolean isBuzz = number % 5 == 0;

        if (isFizz && isBuzz)
            return "FizzBuzz";

        if (isFizz)
            return "Fizz";

        if (isBuzz)
            return "Buzz";

        return number + "";
    }

    public static void main(String[] args) {
        int number = 1;
        for (int i = 0; i < 100; i++) {
            if (number % 2 != 0) {
                System.out.print(fizzBuzz(number));
                System.out.print("\t");
            }
            number++;
        }
    }
}

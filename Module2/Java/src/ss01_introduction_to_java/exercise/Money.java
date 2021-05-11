package ss01_introduction_to_java.exercise;

        import java.util.Scanner;

public class Money {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter USD: ");
        int usd = scanner.nextInt();
        int vnd = usd * 23000;
        System.out.println("VND is: " + vnd + " vnd");
    }
}

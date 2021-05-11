package ss02_loop_to_java.exercise;

import java.util.Scanner;

public class HienThiHinh {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        String result = "";
        do {
            System.out.println("1.Print the rectangle" + "\n" +
                    "2.Print the square triangle" + "\n" +
                    "3.Print isosceles triangle" + "\n" +
                    "4.Exit");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 7; j++) {
                            result += "* ";
                        }
                        result += "\n";
                    }
                    System.out.println(result);
                    break;
                case 2:
                    Show();
                    break;
                case 3:
                    for (int i = 1; i <= 5; i++) {
                        for (int h = 0; h < 5 - i; h++) {
                            result += "  ";
                        }
                        for (int k = 0; k < i; k++) {
                            result += " *";
                        }
                        for (int j = 1; j < i; j++) {
                            result += " *";
                        }
                        result += "\n";
                    }
                    System.out.println(result);
                    break;
                case 4:
                    check = false;
                default:
            }
        } while (check);

    }

    public static void Show() {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        String result = "";
        do {
            System.out.println("1.top-left" + "\n" +
                    "2.top-right" + "\n" +
                    "3.botton-left" + "\n" +
                    "4.botton-right" + "\n");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 1; j <= i; j++) {
                            result += "* ";
                        }
                        result += "\n";
                    }
                    System.out.println(result);
                    check = false;
                    break;
                case 2:
                    for (int i = 1; i <= 5; i++) {
                        for (int j = 0; j < 5 - i; j++) {
                            result += "  ";
                        }
                        for (int k = 0; k < i; k++) {
                            result += " *";
                        }
                        result += "\n";
                    }
                    System.out.println(result);
                    check = false;
                    break;
                case 3:
                    for (int i = 5; i >= 1; i--) {
                        for (int j = 1; j <= i; j++) {
                            result += "* ";
                        }
                        result += "\n";
                    }
                    System.out.println(result);
                    check = false;
                    break;
                case 4:
                    for (int i = 5; i > 0; i--) {
                        for (int j = 0; j < 5 - i; j++) {
                            result += "  ";
                        }
                        for (int k = 0; k < i; k++) {
                            result += " *";
                        }
                        result += "\n";
                    }
                    System.out.println(result);
                    check = false;
                    break;
                default:
            }
        } while (check);
    }
}

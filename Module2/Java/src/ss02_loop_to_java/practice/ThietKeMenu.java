package ss02_loop_to_java.practice;

import java.util.Scanner;

public class ThietKeMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        do {
            System.out.println("1.Draw the triangle" + "\n" +
                    "2.Draw the square" + "\n" +
                    "3.Draw the rectangle" + "\n" +
                    "4.Exit");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    System.out.println("Draw the triangle:" + "\n" + "\n" +
                            "******" + "\n" +
                            "*****" + "\n" +
                            "****" + "\n" +
                            "***" + "\n" +
                            "**" + "\n" +
                            "*" + "\n");
                    break;
                case 2:
                    System.out.println("Draw the square:" + "\n" + "\n" +
                            "* * * * * * * *" + "\n" +
                            "* * * * * * * *" + "\n" +
                            "* * * * * * * *" + "\n" +
                            "* * * * * * * *" + "\n" +
                            "* * * * * * * *" + "\n" +
                            "* * * * * * * *" + "\n");
                    break;
                case 3:
                    System.out.println("Draw the rectangle:"+"\n"+"\n"+
                            "* * * * * * * *"+"\n"+
                            "* * * * * * * *"+"\n"+
                            "* * * * * * * *"+"\n"+
                            "* * * * * * * *"+"\n");
                    break;
                case 4:
                    System.out.println("Goodbye");
                    check=false;
                default:
            }
        } while (check);
    }
}

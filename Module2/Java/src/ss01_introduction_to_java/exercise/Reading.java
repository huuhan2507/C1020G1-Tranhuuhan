package ss01_introduction_to_java.exercise;

import java.util.Scanner;

public class Reading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number: ");
        int number = scanner.nextInt();
        String result = "";
        if (number <= 10) {
            switch (number) {
                case 0:
                    System.out.println("Zero");
                    break;
                case 1:
                    System.out.println("One");
                    break;
                case 2:
                    System.out.println("Two");
                    break;
                case 3:
                    System.out.println("Three");
                    break;
                case 4:
                    System.out.println("Four");
                    break;
                case 5:
                    System.out.println("Five");
                    break;
                case 6:
                    System.out.println("Six");
                    break;
                case 7:
                    System.out.println("Seven");
                    break;
                case 8:
                    System.out.println("Eight");
                    break;
                case 9:
                    System.out.println("Nine");
                    break;
                case 10:
                    System.out.println("Ten");
                default:
                    System.out.println("out of ability");
            }
        } else if (number <= 20) {
            switch (number) {
                case 11:
                    System.out.println("Eleven");
                    break;
                case 12:
                    System.out.println("Twelve");
                    break;
                case 13:
                    System.out.println("Thirteen");
                    break;
                case 14:
                    System.out.println("Fourteen");
                    break;
                case 15:
                    System.out.println("Fifteen");
                    break;
                case 16:
                    System.out.println("Sixteen");
                    break;
                case 17:
                    System.out.println("Seventeen");
                    break;
                case 18:
                    System.out.println("Eighteen");
                    break;
                case 19:
                    System.out.println("Nineteen");
                    break;
                case 20:
                    System.out.println("Twenty");
                    break;
                default:
                    System.out.println("out of ability");
            }
        } else if (number <= 99) {
            String a = number + "";
            char b = a.charAt(0);
            char c = a.charAt(1);
            switch (b) {
                case '2':
                    result += "twenty";
                    break;
                case '3':
                    result += "thirty";
                    break;
                case '4':
                    result += "forty";
                    break;
                case '5':
                    result += "fifty";
                    break;
                case '6':
                    result += "sixty";
                    break;
                case '7':
                    result += "seventy";
                    break;
                case '8':
                    result += "eighty";
                    break;
                case '9':
                    result += "ninety";
                    break;
                default:
            }
            switch (c) {
                case '0':
                    result += "";
                    break;
                case '1':
                    result += " one";
                    break;
                case '2':
                    result += " two";
                    break;
                case '3':
                    result += " three";
                    break;
                case '4':
                    result += " four";
                    break;
                case '5':
                    result += " five";
                    break;
                case '6':
                    result += " six";
                    break;
                case '7':
                    result += " seven";
                    break;
                case '8':
                    result += " eight";
                    break;
                case '9':
                    result += " nine";
                    break;
                default:
                    System.out.println("out of ability");
            }
            System.out.println(result);
        } else if (number < 999) {
            String n = number + "";
            char a = n.charAt(0);
            char b = n.charAt(1);
            char c = n.charAt(2);
            switch (a) {
                case '1':
                    result += "one hundred and ";
                    break;
                case '2':
                    result += "two hundred and ";
                    break;
                case '3':
                    result += "three hundred and ";
                    break;
                case '4':
                    result += "four hundred and ";
                    break;
                case '5':
                    result += "five hundred and ";
                    break;
                case '6':
                    result += "six hundred and ";
                    break;
                case '7':
                    result += "seven hundred and ";
                    break;
                case '8':
                    result += "eight hundred and ";
                    break;
                case '9':
                    result += "nine hundred and ";
                    break;
                default:
            }
            if (b == '1') {
                switch (c) {
                    case '0':
                        result += " ten";
                        break;
                    case '1':
                        result += " eleven";
                        break;
                    case '2':
                        result += " twelve";
                        break;
                    case '3':
                        result += " thirteen";
                        break;
                    case '4':
                        result += " fourteen";
                        break;
                    case '5':
                        result += " fifteen";
                        break;
                    case '6':
                        result += " sixteen";
                        break;
                    case '7':
                        result += " seventeen";
                        break;
                    case '8':
                        result += " eighteen";
                        break;
                    case '9':
                        result += " nineteen";
                        break;
                    default:
                }
            } else {
                switch (b) {
                    case '2':
                        result += "twenty";
                        break;
                    case '3':
                        result += "thirty";
                        break;
                    case '4':
                        result += "forty";
                        break;
                    case '5':
                        result += "fifty";
                        break;
                    case '6':
                        result += "sixty";
                        break;
                    case '7':
                        result += "seventy";
                        break;
                    case '8':
                        result += "eighty";
                        break;
                    case '9':
                        result += "ninety";
                        break;
                    default:
                }
                switch (c) {
                    case '0':
                        result += "";
                        break;
                    case '1':
                        result += " one";
                        break;
                    case '2':
                        result += " two";
                        break;
                    case '3':
                        result += " three";
                        break;
                    case '4':
                        result += " four";
                        break;
                    case '5':
                        result += " five";
                        break;
                    case '6':
                        result += " six";
                        break;
                    case '7':
                        result += " seven";
                        break;
                    case '8':
                        result += " eight";
                        break;
                    case '9':
                        result += " nine";
                        break;
                    default:
                        System.out.println("out of ability");
                }
            }
            System.out.println(result);
        } else System.out.println("Not reading");
    }
}

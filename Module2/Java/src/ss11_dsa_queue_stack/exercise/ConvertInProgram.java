package ss11_dsa_queue_stack.exercise;

import java.util.Scanner;
import java.util.Stack;

public class ConvertInProgram {
    public static void DecimalToBinary(int decimal) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBinary = new StringBuilder();
        int count;
        while (decimal > 0) {
            count = decimal % 2;
            decimal = decimal / 2;
            stack.push( count );
        }
        while (!stack.empty()) {
            stringBinary.append( stack.pop() );
        }
        System.out.println( stringBinary );
    }

    public static void BinaryToDecimal(String binary) {
        double pow;
        double sum = 0;
        Stack<String> stack = new Stack<>();
        String[] array = binary.split( "" );
        for (String s : array) {
            stack.push( s );
        }
        for (int i = 0; i < array.length; i++) {
            String string = stack.pop();
            if (string.equals( "1" )) {
                pow = Math.pow( 2, i );
                sum += pow;
            } else if (string.equals( "0" )) {
                pow = 0;
                sum += pow;
            }
        }
        int sumInt = (int) sum;
        System.out.println( sumInt );
    }

    public static void DecimalToHexadecimal(double decimal) {

        int count = 0;
        double value;
        do {
            decimal /= 16;
            count++;
        } while (decimal > 16);
        StringBuilder string;
        string= new StringBuilder();
        for (int i = count; i >= 0; i--) {
            value = decimal / Math.pow( 16, count );
            if (value > 0) {
                switch ((int) value) {
                    case 1:
                        string.append( "1" );
                        break;
                    case 2:
                        string.append( "2" );
                        break;
                    case 3:
                        string.append( "3" );
                        break;
                    case 4:
                        string.append( "4" );
                        break;
                    case 5:
                        string.append( "5" );
                        break;
                    case 6:
                        string.append( "6" );
                        break;
                    case 7:
                        string.append( "7" );
                        break;
                    case 8:
                        string.append( "8" );
                        break;
                    case 9:
                        string.append( "9" );
                        break;
                    case 10:
                        string.append( "A" );
                        break;
                    case 11:
                        string.append( "B" );
                        break;
                    case 12:
                        string.append( "C" );
                        break;
                    case 13:
                        string.append( "D" );
                        break;
                    case 14:
                        string.append( "E" );
                        break;
                    case 15:
                        string.append( "F" );
                        break;
                    default:
                }
            } else if ((int) value == 0) {
                switch ((int) decimal) {
                    case 0:
                        string.append( "0" );
                        break;
                    case 1:
                        string.append( "1" );
                        break;
                    case 2:
                        string.append( "2" );
                        break;
                    case 3:
                        string.append( "3" );
                        break;
                    case 4:
                        string.append( "4" );
                        break;
                    case 5:
                        string.append( "5" );
                        break;
                    case 6:
                        string.append( "6" );
                        break;
                    case 7:
                        string.append( "7" );
                        break;
                    case 8:
                        string.append( "8" );
                        break;
                    case 9:
                        string.append( "9" );
                        break;
                    case 10:
                        string.append( "A" );
                        break;
                    case 11:
                        string.append( "B" );
                        break;
                    case 12:
                        string.append( "C" );
                        break;
                    case 13:
                        string.append( "D" );
                        break;
                    case 14:
                        string.append( "E" );
                        break;
                    case 15:
                        string.append( "F" );
                        break;
                    default:
                }

            }
            decimal %= Math.pow( 16, count );
        }
        System.out.println(string);
    }

    public static void HexadecimalToDecimal(String hexadecimal) {
    }


    public static void main(String[] args) {
        boolean check = true;
        do {
            Scanner scanner = new Scanner( System.in );
            System.out.println( "Enter : " );
            String string = scanner.nextLine();
            System.out.println( "What do you want to convert to: " + "\n" +
                    "1.Convert Decimal to Binary" + "\n" +
                    "2.Convert Binary to Decimal" + "\n" +
                    "3.Convert Decimal to Hexadecimal" + "\n" +
                    "4.Convert Hexadecimal to Decimal" + "\n" +
                    "5.Exit" );
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    DecimalToBinary( Integer.parseInt( string ) );
                    break;
                case 2:
                    BinaryToDecimal( string );
                    break;
                case 3:
                    DecimalToHexadecimal( Integer.parseInt( string ) );
                    break;
                case 4:
                    HexadecimalToDecimal( string );
                    break;
                case 5:
                    check = false;
                    break;
                default:
            }
        } while (check);

    }
}

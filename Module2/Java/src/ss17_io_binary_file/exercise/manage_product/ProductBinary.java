package ss17_io_binary_file.exercise.manage_product;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ProductBinary {
    static Scanner scanner = new Scanner( System.in );
    static List<Product> productList = new LinkedList<>();

    public static void addProduct() {
        System.out.println( "Enter id product" );
        String id = scanner.nextLine();
        System.out.println( "Enter name product" );
        String name = scanner.nextLine();
        System.out.println( "Enter name code product" );
        String code = scanner.nextLine();
        System.out.println( "Enter price product" );
        int price = scanner.nextInt();
        scanner.nextLine();
        System.out.println( "Enter type of product" );
        String type = scanner.nextLine();
        System.out.println();
        Product product = new Product( id, name, code, price, type );
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream( new FileOutputStream( "src\\ss17_io_binary_file\\exercise\\manage_product\\product_file.csv" ) );
            outputStream.writeObject( product );
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void showProduct() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream( "src\\ss17_io_binary_file\\exercise\\manage_product\\product_file.csv" ) );
            Product product;
            do {
                product = (Product) objectInputStream.readObject();
                productList.add( product );
            } while (product != null);
        } catch (EOFException e) {
            System.err.println();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Product element : productList) {
            System.out.println( element.toString() );
        }
    }

    public static void searchProduct() {
        List<Product> productList = new LinkedList<>();
        System.out.println( "Enter name product" );
        int count;
        String name = scanner.nextLine();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream( new FileInputStream( "src\\ss17_io_binary_file\\exercise\\manage_product\\product_file.csv" ) );
            Product product;
            do {
                product = (Product) objectInputStream.readObject();
                productList.add( product );
            } while (product != null);
        } catch (EOFException e) {
            System.out.println();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        for (Product product : productList) {
            if (name.equals( product.getNameProduct() )) {
                System.out.println( product );
                System.out.println();
                break;
            }
            System.out.println( "No data to display" );
        }
    }

    public static void main(String[] args) {
        boolean check = true;
        do {
            System.out.println( "1.Add Product" );
            System.out.println( "2.Show Product" );
            System.out.println( "3.Search Product" );
            System.out.println( "4.Exit" );
            System.out.println( "What do you want to choose" );
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    addProduct();
                    break;
                case "2":
                    showProduct();
                    break;
                case "3":
                    searchProduct();
                    break;
                case "4":
                    check = false;
                    break;
                default:
                    System.err.println( "There is no such choice" );
            }

        } while (check);
    }
}

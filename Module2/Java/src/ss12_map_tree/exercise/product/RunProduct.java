package ss12_map_tree.exercise.product;

import java.util.ArrayList;
import java.util.Scanner;

public class RunProduct {
    public static void main(String[] args) {
        Product product = new Product( 1, "Iphone", 1700 );
        Product product2 = new Product( 2, "OppoReNo", 1000 );
        Product product3 = new Product( 3, "Samsung", 1200 );
        ArrayList<Product> products = new ArrayList<>();
        products.add( product );
        products.add( product2 );
        products.add( product3 );
        ProductManager productManager = new ProductManager( products );

        boolean check = true;
        do {
            Scanner scanner = new Scanner( System.in );
            System.out.println("------------Menu--------------");
            System.out.println(
                    "1.Add product" + "\n" +
                            "2.Delete product" + "\n" +
                            "3.Edit product" + "\n" +
                            "4.Search product" + "\n" +
                            "5.Show all product" + "\n" +
                            "6.Sort product" + "\n" +
                            "7.Exit" );
            System.out.println( "-------------------------------" );
            System.out.println( "What do you want to choose?" );
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    productManager.addNewProduct();
                    break;
                case 2:
                    productManager.showProduct();
                    productManager.deleteProduct();
                    break;
                case 3:
                    productManager.showProduct();
                    productManager.editProduct();
                    break;
                case 4:
                    productManager.searchProduct();
                    break;
                case 5:
                    productManager.showProduct();
                    break;
                case 6:
                    productManager.SortPrice();
                    break;
                case 7:
                    check = false;
                    break;
                default:
            }
        } while (check);
    }
}

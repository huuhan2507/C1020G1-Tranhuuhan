package ss12_map_tree.exercise.product;

import java.util.*;

public class ProductManager {
    private List<Product> productList;

    public ProductManager(ArrayList<Product> list) {
        productList = new LinkedList<>();
        productList.addAll( list );
    }

    Scanner scanner = new Scanner( System.in );

    public boolean check(int id, String name) {
        for (Product value : productList) {
            if (id == value.getId()) {
                return false;
            }
        }
        for (Product product : productList) {
            if (name.equals( product.getName() )) {
                return false;
            }
        }
        return true;
    }

    public void addNewProduct() {
        int id;
        String name;
        int price;
        do {
            System.out.println( "id: " );
            id = scanner.nextInt();
            scanner.nextLine();
            System.out.println( "name: " );
            name = scanner.nextLine();
            if (!check( id, name )) {
                System.out.println( "the product you added already has" );
                System.out.println();
                System.out.println( "------------------------------------------" );
            }
        } while (!check( id, name ));
        System.out.println( "Price: " );
        price = scanner.nextInt();
        productList.add( new Product( id, name, price ) );
        System.out.println( "added successfully" );
        System.out.println();
        System.out.println( "---------------------------" );
    }

    public void deleteProduct() {
        boolean check = true;

        do {
            System.out.println( "Enter id product you want delete: " );
            int id = scanner.nextInt();
            for (int i = 0; i < productList.size(); i++) {
                if (id == productList.get( i ).getId()) {
                    Product remove = productList.remove( i );
                    System.out.println(remove);
                    check = false;
                }
            }
            if (check) {
                System.out.println( "There is no id you want to delete" );
                System.out.println();
                System.out.println( "------------------------------------------" );
            } else {
                System.out.println( "delete successfully" );
                System.out.println();
                System.out.println( "------------------------------------------" );
            }

        } while (check);
    }

    public void searchProduct() {
        boolean check = true;
        do {
            System.out.println( "enter the product name you want to find: " );
            String name = scanner.nextLine().toLowerCase();
            for (Product product : productList) {
                if (name.equals( product.getName().toLowerCase() )) {
                    System.out.println( product );
                    System.out.println();
                    System.out.println( "--------------------------------" );
                    check = false;
                }
            }
            if (check) {
                System.out.println( "There are no products you are looking for" );
                System.out.println();
                System.out.println( "------------------------------------------" );
            }
        } while (check);
    }

    public void editProduct() {
        boolean check = true;
        do {
            System.out.println( "Enter the product id you want to edit: " );
            int id = scanner.nextInt();
            for (int i = 0; i < productList.size(); i++) {
                if (id == productList.get( i ).getId()) {
                    int id1;
                    String name;
                    do {
                        System.out.println( "Enter id: " );
                        id1 = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println( "Enter name: " );
                        name = scanner.nextLine();
                        if (!check( id1, name )) {
                            System.out.println( "the product you repair already has" );
                        }
                    } while (!check( id1, name ));
                    System.out.println( "Enter price: " );
                    int price = scanner.nextInt();
                    productList.set( i, new Product( id, name, price ) );
                    check = false;
                }
            }
            if (check) {
                System.out.println( "There are no products you are edit for" );
                System.out.println();
                System.out.println( "------------------------------------------" );
            } else {
                System.out.println( "edit successfully" );
                System.out.println();
                System.out.println( "-----------------------------" );
            }
        } while (check);

    }

    public void showProduct() {
        System.out.println("-------------Products---------------");
        for (int i = 0; i < productList.size(); i++) {
            System.out.println( (i + 1) + ".\t" + "Id: " + productList.get( i ).getId() + "\t" +
                    "Name: " + productList.get( i ).getName() + "\t" + "Price: " + productList.get( i ).getPrice() );
        }
        System.out.println();
        System.out.println( "-------------------------------" );
    }

    public void SortPrice() {
        SortPriceUp sortPriceUp = new SortPriceUp();
        SortPriceDown sortPriceDown = new SortPriceDown();
        System.out.println( "1. Sort up Product: " );
        System.out.println( "2. Sort down product: " );
        System.out.println( "What sort of arrangement do you want to choose ?" );
        int choose = scanner.nextInt();
        switch (choose) {
            case 1:
                productList.sort( sortPriceUp );
                for (Product element : productList) {
                    System.out.println( element );
                }
                System.out.println();
                System.out.println( "------------------------------------------" );
                break;
            case 2:
                productList.sort( sortPriceDown );
                for (Product element : productList) {
                    System.out.println( element );
                }
                System.out.println();
                System.out.println( "------------------------------------------" );
                break;
            default:
                System.out.println( "The type you selected is not included in the item" );
                System.out.println();
                System.out.println( "------------------------------------------" );
        }
    }

}

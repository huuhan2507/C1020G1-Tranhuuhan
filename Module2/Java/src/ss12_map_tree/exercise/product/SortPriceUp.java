package ss12_map_tree.exercise.product;

import java.util.Comparator;

public class SortPriceUp implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice() - o2.getPrice();
    }
}

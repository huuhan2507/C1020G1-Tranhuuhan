package repository.impl;

import bean.Product;
import repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ProductRepositoryImpl implements ProductRepository {
   public static Map<Integer,Product> productMap = new TreeMap<>(  );
    static {
        productMap.put( 1,new Product( 1,"ABC","Iphone","1500" ) );
        productMap.put( 2,new Product( 2,"ACC","Samsung","1700" ) );
        productMap.put( 3,new Product( 3,"ADC","Oppo","1900" ) );
        productMap.put( 4,new Product( 4,"AEC","Nokia","1800" ) );
    }

    @Override
    public List<Product> displayProduct() {
        return new ArrayList<>( productMap.values() );
    }

    @Override
    public void deleteProduct(Integer id) {
        productMap.remove( id );
    }

    @Override
    public void save(Product product) {
        productMap.put( product.getId(),product );
    }

    @Override
    public Product showInfoProduct(Integer id) {
        return productMap.get( id );
    }
}

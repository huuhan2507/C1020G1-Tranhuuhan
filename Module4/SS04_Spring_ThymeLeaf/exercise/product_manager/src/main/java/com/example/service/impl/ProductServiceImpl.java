package com.example.service.impl;

import com.example.model.Product;
import com.example.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> productMap;
    static {
        productMap= new HashMap<>(  );
        productMap.put(1, new Product(1,"Iphone",100,1500,"On"  ) );
        productMap.put(2,new Product( 2,"Samsung",100,1200,"On" ) );
        productMap.put(3,new Product( 3,"Oppo",150,900,"On" ) );
        productMap.put(4, new Product( 4,"Nokia",100,700,"Off" ) );
        productMap.put(5, new Product( 5,"Huawei",120,800,"Off" ) );
    }
    @Override
    public List<Product> showProduct() {
        return new ArrayList<>( productMap.values() );
    }


    @Override
    public void saveProduct(Product product){
        productMap.put( product.getId(),product );
    }

    @Override
    public Product findById(int id) {
        return productMap.get( id );
    }

    @Override
    public void updateProduct(int id, Product product) {
        productMap.put( id,product );
    }

    @Override
    public void removeProduct(int id) {
        productMap.remove( id );
    }

    @Override
    public boolean checkId(int id) {
        return !productMap.containsKey( id );
    }
}

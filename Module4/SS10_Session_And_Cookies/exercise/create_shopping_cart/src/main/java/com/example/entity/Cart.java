package com.example.entity;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product,Integer> carts;

    public Cart(){
        carts = new HashMap<>();
    }

    public Map<Product,Integer> getCarts(){
        return carts;
    }

    public void save(Product product){
        if (carts.containsKey(product)){
            carts.replace(product, carts.get(product), carts.get(product)+1);
        } else {
            carts.put(product,1);
        }
    }

    public void delete(Product product){
        if (carts.get(product) == 1){
            carts.remove(product);
        } else {
            carts.replace(product, carts.get(product), carts.get(product)-1);
        }
    }

    public void deleteAll(){
        carts.clear();
    }




}

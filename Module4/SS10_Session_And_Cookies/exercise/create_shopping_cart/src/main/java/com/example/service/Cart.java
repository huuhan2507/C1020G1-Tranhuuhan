package com.example.service;

import com.example.entity.Product;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> carts;

    public Cart() {
        carts = new HashMap<>();
    }

    public Map<Product, Integer> getCarts() {
        return carts;
    }

    public void save(Product product,Integer amount) {
        if (carts.containsKey( product )) {
            carts.replace( product, carts.get( product ), carts.get( product ) +amount);
        } else {
            carts.put( product, amount );
        }
    }

    public void delete(Product product) {
        carts.remove( product );
    }

    public void edit(Product product , Integer amount){
        carts.replace( product,carts.get( product ),amount );
    }

    public double totalMoney() {
        double totalMoney = 0.0;
        for (Map.Entry<Product, Integer> entry : getCarts().entrySet()) {
            totalMoney += entry.getKey().getPrice() * entry.getValue() * (1 - entry.getKey().getDiscount() / 100);
        }
        return totalMoney;
    }

    public void deleteAll() {
        carts.clear();
    }

}

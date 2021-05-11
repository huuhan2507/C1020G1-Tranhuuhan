package com.example.service;

import com.example.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> showProduct();
    void saveProduct( Product product);
    Product findById(int id);
    void updateProduct(int id, Product product);
    void removeProduct(int id);
    boolean checkId(int id);
}

package com.example.service;

import com.example.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> showAllProduct();
    void createProduct(Product product);
    void deleteProduct(Integer id);
    void editProduct(Product product);
    Product findProductById(Integer id);
    void saveProduct(String action , Product product);
}

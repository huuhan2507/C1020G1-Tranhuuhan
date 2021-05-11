package repository;

import bean.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> displayProduct();
    void deleteProduct(Integer id);
    void save(Product product);
    Product showInfoProduct(Integer id);

}

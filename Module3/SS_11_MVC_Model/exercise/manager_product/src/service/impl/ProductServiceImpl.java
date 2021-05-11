package service.impl;

import bean.Product;
import repository.ProductRepository;
import repository.impl.ProductRepositoryImpl;
import service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository = new ProductRepositoryImpl();

        @Override
        public List<Product> displayProduct() {
            return productRepository.displayProduct();
        }

        @Override
        public void deleteProduct(Integer id) {
            productRepository.deleteProduct( id );
        }

        @Override
        public void save(Product product) {
            productRepository.save( product );
        }

        @Override
        public Product showInfoProduct(Integer id) {
            return productRepository.showInfoProduct( id );
        }

}

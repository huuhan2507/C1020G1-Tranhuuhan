package com.auction_website.repository;

import com.auction_website.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product \n" +
            "WHERE product.product_status_id = 2\n" +
            "ORDER BY product.product_register_time DESC" ,nativeQuery = true)
    List<Product> showAllProductAuction();
}

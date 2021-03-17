package com.example.repository;

import com.example.entity.contract.Contract;
import com.example.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    Customer findCustomerByCustomerCode(String code);

    @Query(value = "select * from customer c where concat(c.customer_id,c.customer_name,c.customer_phone,c.customer_email) like %:key%", nativeQuery = true)
    Page<Customer> findByContaining(@Param("key") String key, Pageable pageable);

}

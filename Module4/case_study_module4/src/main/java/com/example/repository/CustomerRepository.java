package com.example.repository;

import com.example.entity.contract.Contract;
import com.example.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Page<Customer> findAll(Pageable pageable);

    Page<Customer> findCustomersByCustomerNameContains(String name,Pageable pageable);

}

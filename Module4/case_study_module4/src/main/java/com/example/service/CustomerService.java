package com.example.service;


import com.example.entity.customer.Customer;
import com.example.entity.customer.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);

    void deleteAll();

    Page<Customer> search(String search, Pageable pageable);

    List<CustomerType> findAllCustomerType();

    boolean checkCustomerCode(String code);
}

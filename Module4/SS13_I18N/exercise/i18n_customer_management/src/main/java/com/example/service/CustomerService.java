package com.example.service;

import com.example.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAllCustomer();

    void save(Customer customer);

    void delete(Integer id);

    Customer findById(Integer id);
}

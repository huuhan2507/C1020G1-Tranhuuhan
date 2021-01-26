package com.codegym.repository;

import com.codegym.bean.Customer;

import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
    void delete(Integer id);
}

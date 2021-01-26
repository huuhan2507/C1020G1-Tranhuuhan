package com.codegym.service;

import com.codegym.bean.Customer;

import java.util.List;

public interface CustomerService {
    void save(Customer customer);
    List<Customer> findAll();
    Customer findById(Integer id);
    void delete(Integer id);
}

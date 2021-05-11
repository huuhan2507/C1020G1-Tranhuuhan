package com.codegym.service.impl;

import com.codegym.bean.Customer;
import com.codegym.service.CustomerService;
import com.codegym.repository.CustomerRepository;
import com.codegym.repository.impl.CustomerRepositoryImpl;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
   private CustomerRepository customerRepository= new CustomerRepositoryImpl();

    @Override
    public void save(Customer customer) {
     customerRepository.save( customer );
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById( id );
    }

    @Override
    public void delete(Integer id) {
     customerRepository.delete( id );
    }
}

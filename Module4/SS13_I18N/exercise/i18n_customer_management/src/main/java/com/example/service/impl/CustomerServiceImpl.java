package com.example.service.impl;

import com.example.model.Customer;
import com.example.repository.CustomerRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomer() {
       return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save( customer );
    }

    @Override
    public void delete(Integer id) {
        customerRepository.deleteById( id );
    }

    @Override
    public Customer findById(Integer id) {
        return customerRepository.findById( id ).orElse( null );
    }
}

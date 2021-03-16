package com.example.service.impl;

import com.example.entity.customer.Customer;
import com.example.entity.customer.CustomerType;
import com.example.repository.CustomerRepository;
import com.example.repository.CustomerTypeRepository;
import com.example.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    CustomerTypeRepository customerTypeRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll( pageable );
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

    @Override
    public void deleteAll() {
        customerRepository.deleteAll();
    }

    @Override
    public Page<Customer> searchByName(String name, Pageable pageable) {
        return customerRepository.findCustomersByCustomerNameContains( name, pageable );
    }

    @Override
    public List<CustomerType> findAllCustomerType() {
        return customerTypeRepository.findAll();
    }
}

package com.example.service;

import com.example.entity.Customer;
import com.example.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerService {
    Page<Customer> findAll(Pageable pageable);

    Optional<Customer> findById(Long id);

    void save(Customer customer);

    void remove(Long id);

    Iterable<Customer> findAllByProvince(Optional<Province> province);
}

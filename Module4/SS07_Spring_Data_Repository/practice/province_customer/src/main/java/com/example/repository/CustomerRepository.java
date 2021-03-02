package com.example.repository;

import com.example.entity.Customer;
import com.example.entity.Province;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Optional<Province> province);

    Page<Customer> findAll(Pageable pageable);
}
package com.example.service;

import com.example.entity.customer.CustomerType;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerTypeService {
    List<CustomerType> findAll();
}

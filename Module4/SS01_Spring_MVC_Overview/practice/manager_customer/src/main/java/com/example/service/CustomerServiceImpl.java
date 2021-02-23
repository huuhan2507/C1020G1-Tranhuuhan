package com.example.service;

import com.example.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> showCustomer() {
        List<Customer> customerList = new ArrayList<>(  );
        customerList.add( new Customer( "Han",17,"huuhan05@gmail.com" ) );
        customerList.add( new Customer( "Hien",23,"huuhien25@gmail.com" ) );
        customerList.add( new Customer( "Phin",19,"phin1212@gmail.com" ) );
        customerList.add( new Customer( "Kien",24,"kien3553@gmail.com" ) );
        return customerList;
    }
}

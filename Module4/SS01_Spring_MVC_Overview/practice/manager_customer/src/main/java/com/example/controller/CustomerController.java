package com.example.controller;

import com.example.model.Customer;
import com.example.service.CustomerService;
import com.example.service.CustomerServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CustomerController {
    CustomerService customerService = new CustomerServiceImpl();
    @GetMapping("/home")
    public String goHome(Model model){
        model.addAttribute( "listCustomer", customerService.showCustomer() );
        return "/home";
    }
}

package com.example.controller;

import com.example.entity.Cart;
import com.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/")
    public String home(Model model, Pageable pageable){
        model.addAttribute( "products",productService.findAllProduct( pageable ) );
        return "/home";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id, Model model){
        model.addAttribute( "product",productService.findById( id ) );
        model.addAttribute( "cart", new Cart() );
        return "/view";
    }
}

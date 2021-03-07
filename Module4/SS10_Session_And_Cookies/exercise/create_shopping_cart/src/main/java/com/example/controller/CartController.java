package com.example.controller;

import com.example.entity.Cart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CartController {
    @PostMapping("/addcart")
    public String addCart(@ModelAttribute Cart cart){
        return "redirect:/";
    }
}

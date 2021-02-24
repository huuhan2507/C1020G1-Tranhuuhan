package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {
    @GetMapping("/")
    public String goHome(){
        return "/home";
    }
    @GetMapping("/select")
    public String selectCondiment(@RequestParam String select, Model model){
        model.addAttribute( "sandwich", "Condiment: "+ select );
        return "/home";
    }
}

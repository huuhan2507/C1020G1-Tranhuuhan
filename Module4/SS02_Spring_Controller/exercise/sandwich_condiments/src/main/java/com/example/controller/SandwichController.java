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
    @GetMapping("/sandwich")
    public String selectCondiment(@RequestParam String condiments, Model model){
        model.addAttribute( "condiment", "Condiment: "+ condiments );
        return "/home";
    }
}

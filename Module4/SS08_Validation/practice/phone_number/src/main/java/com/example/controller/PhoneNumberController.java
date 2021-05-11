package com.example.controller;

import com.example.model.PhoneNumber;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PhoneNumberController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute( "phoneNumber", new PhoneNumber() );
        return "/home";
    }
    @PostMapping("/create")
    public String create(@Validated PhoneNumber phoneNumber, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute( "phoneNumber",phoneNumber );
            return "/home";
        }else {
            model.addAttribute( "phoneNumber",phoneNumber );
            return "/result";
        }
    }
}

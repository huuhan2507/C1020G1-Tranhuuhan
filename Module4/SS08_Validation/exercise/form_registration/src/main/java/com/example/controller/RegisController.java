package com.example.controller;

import com.example.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisController {
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute( "user",new User() );
        return "home";
    }
    @PostMapping("/save")
    public String registration(@Validated @ModelAttribute("user") User user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute( "user",user );
            return "home";
        }else {
            model.addAttribute( "user",user );
            return "result";
        }
    }
}

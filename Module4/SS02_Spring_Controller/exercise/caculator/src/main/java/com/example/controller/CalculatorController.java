package com.example.controller;

import com.example.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    private CalculatorService calculatorService;
    @GetMapping("/")
    public String goHome() {
        return "/home";
    }

    @GetMapping("/calculator")
    public String calculation(@RequestParam double number1, @RequestParam double number2, @RequestParam String calculation, Model model) {
        String stringResult = calculatorService.calculate( number1,number2,calculation );
        model.addAttribute( "result",stringResult );
        model.addAttribute( "number1", number1 );
        model.addAttribute( "number2", number2 );
        return "/home";
    }
}

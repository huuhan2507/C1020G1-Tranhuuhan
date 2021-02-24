package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("/")
    public String goHome() {
        return "/home";
    }

    @GetMapping("/calculator")
    public String calculation(@RequestParam double number1, @RequestParam double number2, @RequestParam String calculation, Model model) {
        double result = 0;
        if (calculation.equals( "Div" )){
            if (number2==0){
                model.addAttribute( "message","Cannot Be Divided By 0" );
            }else {
                result = number1 / number2;
                String stringResult = "Result: " + result;
                model.addAttribute( "result", stringResult );
            }
        }else {
            switch (calculation) {
                case "Add":
                    result = number1 + number2;
                    break;
                case "Sub":
                    result = number1 - number2;
                    break;
                case "Mul":
                    result = number1 * number2;
                    break;
                default:
            }
            String stringResult = "Result: " + result;
            model.addAttribute( "result", stringResult );
        }
        model.addAttribute( "number1", number1 );
        model.addAttribute( "number2", number2 );
        return "/home";
    }
}

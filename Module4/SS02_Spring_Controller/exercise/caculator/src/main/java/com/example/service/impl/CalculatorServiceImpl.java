package com.example.service.impl;

import com.example.service.CalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {
    @Override
    public String calculate(double number1, double number2, String calculation) {
        String stringResult ;
        double result = 0;
        if (calculation.equals( "Div" )){
            if (number2==0){
                stringResult = "None";
            }else {
                result = number1 / number2;
                stringResult = "Result: " + result;
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
            stringResult = "Result: " + result;
        }
        return stringResult;
    }
}

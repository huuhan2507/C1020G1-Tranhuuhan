package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ConvertController {
    @GetMapping("/home")
    public String goHome(){
        return "/home";
    }
    @PostMapping("/home")
    public String convert(HttpServletRequest request , Model model){
        int usd = Integer.parseInt( request.getParameter( "usd" ) );
        int vnd = usd*23000;
        model.addAttribute( "vnd", "VND:" + vnd );
        model.addAttribute( "usd", usd );
        return "/home";
    }
}

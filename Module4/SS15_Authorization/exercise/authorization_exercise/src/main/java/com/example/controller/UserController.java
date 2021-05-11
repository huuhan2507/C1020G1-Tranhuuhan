package com.example.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class UserController {
    @GetMapping("/")
    public String home() {
        return "/home";
    }

    @GetMapping("/403")
    public String error() {
        return "/error";
    }

    @GetMapping("/admin")
    public String pageAdmin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String pageUser(Principal principal, Model model) {
        model.addAttribute( "auth", principal.getName());
        return "/user";
    }

    @GetMapping("/login")
    public String login() {
        return "/login";
    }
}

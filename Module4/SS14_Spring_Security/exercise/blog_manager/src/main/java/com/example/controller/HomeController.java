package com.example.controller;

import com.example.service.BlogService;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute( "listBlog",blogService.findAllBlog(pageable) );
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        return "/blog/home";
    }

    @GetMapping("/login")
    public String formLogin(){
        return "/loginPage";
    }

    @GetMapping("/403")
    public String error(){
        return "error";
    }

    @GetMapping("/logoutSuccessful")
    public String home1(Model model, @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute( "message", "Logout Success !" );
        model.addAttribute( "listBlog",blogService.findAllBlog(pageable) );
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        return "/blog/home";
    }

}

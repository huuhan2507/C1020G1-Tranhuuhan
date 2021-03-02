package com.example.controller;

import com.example.entity.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @GetMapping("/")
    public String goHome(Model model){
        model.addAttribute( "listBlog",blogService.findAllBlog() );
        return "/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute( "blog",new Blog() );
        return "/save";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id , Model model){
        model.addAttribute( "blog",blogService.findBlogById( id ).get() );
        return "/save";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        blogService.deleteBlog( id );
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute( "blog",blogService.findBlogById( id ).get() );
        return "/view";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog){
        blogService.saveBlog( blog );
        return "redirect:/";
    }
}

package com.example.controller;

import com.example.entity.Blog;
import com.example.service.BlogService;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
public class BlogController {
    @Autowired
    BlogService blogService;
    @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String goHome( Model model){
        model.addAttribute( "listBlog",blogService.findAllBlogByNumber( 5 ));
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        model.addAttribute( "number", 5 );
        return "/blog/home";
    }
    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        model.addAttribute( "blog",new Blog() );
        return "/blog/create";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id , Model model){
        model.addAttribute( "blog",blogService.findBlogById( id ));
        return "/blog/edit";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
        blogService.deleteBlog( id );
        return "redirect:/";
    }
    @GetMapping("/view/{id}")
    public String view(@PathVariable Integer id,Model model){
        model.addAttribute( "blog",blogService.findBlogById( id ) );
        return "/blog/view";
    }
    @GetMapping("/view_by_blog/{id}")
    public String viewByBlog(@PathVariable Integer id,Model model , @PageableDefault(size = 5) Pageable pageable){
        model.addAttribute( "listBlog",blogService.findBlogByCategory_Id( id,pageable ) );
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        return "/blog/home";
    }
    @GetMapping("/sort")
    public String sort( Model model,@PageableDefault(size = 5) Pageable pageable){
        model.addAttribute( "listBlog",blogService.findBlogByOrderByDateAsc(pageable));
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        return "/blog/home";
    }
    @PostMapping("/save")
    public String save(@ModelAttribute Blog blog){
        blogService.saveBlog( blog );
        return "redirect:/";
    }
    @GetMapping("/blog/search")
    public String search(@RequestParam String search, Model model,@RequestParam("number") Integer number){
        model.addAttribute( "listBlog",blogService.findBlogByNameContains( search, number ) );
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        model.addAttribute( "number",number );
        model.addAttribute( "search",search );
        return "/blog/home";
    }
    @GetMapping("/blog/seemore")
    public String seeMore(@RequestParam String search, Model model,@RequestParam("number") Integer number){
        model.addAttribute( "listBlog",blogService.findBlogByNameContains( search, number ) );
        model.addAttribute( "listCategory",categoryService.findAllCategory() );
        model.addAttribute( "search",search );
        return "/blog/home";
    }

}

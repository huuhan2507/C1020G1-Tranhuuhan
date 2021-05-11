package com.example.controller;

import com.example.entity.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> listAllBlog() {
        List<Blog> blog = blogService.findAllBlog( );
        if (blog.isEmpty()) {
            return new ResponseEntity<>( HttpStatus.NO_CONTENT );
        }
        return new ResponseEntity<List<Blog>>( blog, HttpStatus.OK );
    }


    @GetMapping(value = "/blogs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBLog(@PathVariable("id") Integer id) {
        Blog blog = blogService.findBlogById( id );
        if (blog == null) {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND );
        }
        return new ResponseEntity<>( blog, HttpStatus.OK );
    }

}

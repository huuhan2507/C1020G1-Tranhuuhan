package com.example.controller;

import com.example.entity.Blog;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public ResponseEntity<List<Blog>> listAllBlogs() {
        List<Blog> blogList = blogService.findAllBlog();
        if (blogList.isEmpty()) {
            return new ResponseEntity<List<Blog>>( HttpStatus.NO_CONTENT );
        }
        return new ResponseEntity<List<Blog>>( blogList, HttpStatus.OK );
    }

    @GetMapping(value = "/blogs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Blog> getBlog(@PathVariable("id") Integer id) {
        System.out.println( "Fetching Customer with id " + id );
        Blog blog = blogService.findBlogById( id );
        if (blog == null) {
            System.out.println( "Customer with id " + id + " not found" );
            return new ResponseEntity<Blog>( HttpStatus.NOT_FOUND );
        }
        return new ResponseEntity<Blog>( blog, HttpStatus.OK );
    }
    @PostMapping("/blogs")
    public ResponseEntity<Void> createBlog(@RequestBody Blog blog, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println( "Creating Customer " + blog.getName() );
        blogService.saveBlog( blog );
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path( "/customers/{id}" ).buildAndExpand( blog.getId() ).toUri() );
        return new ResponseEntity<Void>( headers, HttpStatus.CREATED );
    }
    @PutMapping("/blogs/{id}")
    public ResponseEntity<Blog> updateBlog(@PathVariable("id") Integer id, @RequestBody Blog blog) {
        System.out.println( "Updating Customer " + id );

        Blog blog1 = blogService.findBlogById( id );

        if (blog1 == null) {
            System.out.println( "Customer with id " + id + " not found" );
            return new ResponseEntity<Blog>( HttpStatus.NOT_FOUND );
        }
        blogService.saveBlog( blog );
        return new ResponseEntity<Blog>( blog1, HttpStatus.OK );
    }
    @DeleteMapping("/blogs/{id}")
    public ResponseEntity<Blog> deleteCustomer(@PathVariable("id") Integer id) {
        System.out.println( "Fetching & Deleting Customer with id " + id );

        Blog blog = blogService.findBlogById( id );
        if (blog == null) {
            System.out.println( "Unable to delete. Customer with id " + id + " not found" );
            return new ResponseEntity<Blog>( HttpStatus.NOT_FOUND );
        }

        blogService.deleteBlog( id );
        return new ResponseEntity<Blog>( HttpStatus.NO_CONTENT );
    }

}

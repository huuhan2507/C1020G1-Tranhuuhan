package com.example.service;

import com.example.entity.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BlogService {
    List<Blog> findAllBlog();
    Optional<Blog> findBlogById(Integer id);
    void deleteBlog(Integer id);
    void saveBlog(Blog blog);
}

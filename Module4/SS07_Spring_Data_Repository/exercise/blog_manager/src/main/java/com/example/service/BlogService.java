package com.example.service;

import com.example.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BlogService {
    Page<Blog> findAllBlog(Pageable pageable);
    Optional<Blog> findBlogById(Integer id);
    void deleteBlog(Integer id);
    void saveBlog(Blog blog);
    Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable);
    Page<Blog> findBlogByNameContains(String search , Pageable pageable);

}
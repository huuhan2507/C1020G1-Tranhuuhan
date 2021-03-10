package com.example.service;

import com.example.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BlogService {
    List<Blog> findAllBlog();

    Optional<Blog> findBlogById(Integer id);

    void deleteBlog(Integer id);

    void saveBlog(Blog blog);

    Page<Blog> findBlogByCategory_Id(Integer id, Pageable pageable);

    Page<Blog> findBlogByNameContains(String search, Pageable pageable);

    Page<Blog> findBlogByOrderByDateAsc(Pageable pageable);

    List<Blog> findAllBlogByNumber(Integer number);
}

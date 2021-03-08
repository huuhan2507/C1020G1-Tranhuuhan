package com.example.service.impl;

import com.example.entity.Blog;
import com.example.repository.BlogRepository;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public List<Blog> findAllBlog() {
       return blogRepository.findAll();
    }

    @Override
    public Blog findBlogById(Integer id) {
        return blogRepository.findBlogById(id);
    }

    @Override
    public void deleteBlog(Integer id) {
        blogRepository.deleteById( id );
    }

    @Override
    public void saveBlog(Blog blog) {
        blogRepository.save( blog );
    }

}

package com.example.service.impl;

import com.example.entity.Blog;
import com.example.repository.BlogRepository;
import com.example.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

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
        return blogRepository.findById( id ).orElse( null );
    }

}

package com.example.service.impl;

import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save( category );
    }

    @Override
    public void deleteCategory(Integer id) {
        categoryRepository.deleteById( id );
    }

    @Override
    public Category findCategoryById(Integer id) {
        return categoryRepository.findCategoryById( id );
    }
}

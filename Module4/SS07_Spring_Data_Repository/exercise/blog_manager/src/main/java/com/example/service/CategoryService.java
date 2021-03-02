package com.example.service;

import com.example.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    void saveCategory(Category category);

    void deleteCategory(Integer id);

    Category findCategoryById(Integer id);
}

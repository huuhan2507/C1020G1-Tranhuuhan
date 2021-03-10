package com.example.service;

import com.example.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAllCategory();

    Category findCategoryById(Integer id);

}

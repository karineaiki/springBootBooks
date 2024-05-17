package com.apirest.simplon.repository;

import java.util.List;

import com.apirest.simplon.model.Category;

public interface CategoryRepository {

    List<Category> findAll();

    Category save(Category category);
    
}

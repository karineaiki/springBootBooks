package com.apirest.simplon.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.simplon.model.Category;
import com.apirest.simplon.repository.CategoryRepository;

@RestController
public class CategoryController {
    private CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepositoryInjected) {
        this.categoryRepository = categoryRepositoryInjected;
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return this.categoryRepository.findAll();
    }

    @PostMapping("/categories")
    public Category postCategory(@RequestBody Category category) {
        return this.categoryRepository.save(category);
    }
}

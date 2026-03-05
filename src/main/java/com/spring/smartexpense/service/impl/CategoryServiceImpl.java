package com.spring.smartexpense.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.smartexpense.dto.CategoryDTO;
import com.spring.smartexpense.entity.Category;
import com.spring.smartexpense.repository.CategoryRepository;
import com.spring.smartexpense.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // Add Category
    @Override
    public CategoryDTO addCategory(CategoryDTO dto) {

        Category category = new Category();
        category.setName(dto.getName());

        Category savedCategory = categoryRepository.save(category);

        CategoryDTO response = new CategoryDTO();
        response.setId(savedCategory.getId());
        response.setName(savedCategory.getName());

        return response;
    }

    // Get All Categories
    @Override
    public List<CategoryDTO> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();

        return categories.stream().map(category -> {

            CategoryDTO dto = new CategoryDTO();
            dto.setId(category.getId());
            dto.setName(category.getName());

            return dto;

        }).collect(Collectors.toList());
    }

    // Delete Category
    @Override
    public void deleteCategory(Long id) {

        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }

        categoryRepository.deleteById(id);
    }
}
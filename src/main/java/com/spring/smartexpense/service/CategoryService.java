package com.spring.smartexpense.service;

import java.util.List;

import com.spring.smartexpense.dto.CategoryDTO;

public interface CategoryService {

    CategoryDTO addCategory(CategoryDTO categoryDTO);

    List<CategoryDTO> getAllCategories();

    void deleteCategory(Long id);

}
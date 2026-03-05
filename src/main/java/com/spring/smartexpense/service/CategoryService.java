package com.spring.smartexpense.service;

import java.util.List;
import com.spring.smartexpense.entity.Category;

public interface CategoryService {

    Category addCategory(Category category);

    List<Category> getAllCategories();

    void deleteCategory(Long id);

}
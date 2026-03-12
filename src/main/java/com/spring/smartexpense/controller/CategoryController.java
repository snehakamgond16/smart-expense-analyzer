package com.spring.smartexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.*;
import com.spring.smartexpense.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<CategoryDTO>> addCategory(@RequestBody CategoryDTO dto) {

        CategoryDTO saved = categoryService.addCategory(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Category created successfully", saved));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<CategoryDTO>>> getAllCategories() {

        List<CategoryDTO> list = categoryService.getAllCategories();

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Categories fetched successfully", list));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCategory(@PathVariable Long id) {

        categoryService.deleteCategory(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Category deleted successfully", null));
    }
}
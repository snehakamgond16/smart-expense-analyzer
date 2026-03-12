package com.spring.smartexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.ApiResponse;
import com.spring.smartexpense.dto.BudgetDTO;
import com.spring.smartexpense.service.BudgetService;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<BudgetDTO>> addBudget(@RequestBody BudgetDTO dto) {

        BudgetDTO saved = budgetService.addBudget(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Budget added successfully", saved));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<BudgetDTO>>> getAllBudgets() {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Budgets fetched successfully",
                        budgetService.getAllBudgets()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteBudget(@PathVariable Long id) {

        budgetService.deleteBudget(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Budget deleted successfully", null));
    }
}
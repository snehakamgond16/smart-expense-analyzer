package com.spring.smartexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.BudgetDTO;
import com.spring.smartexpense.service.BudgetService;

@RestController
@RequestMapping("/api/budgets")
public class BudgetController {

    @Autowired
    private BudgetService budgetService;

    // Add Budget
    @PostMapping("/add")
    public ResponseEntity<BudgetDTO> addBudget(@RequestBody BudgetDTO dto) {

        BudgetDTO savedBudget = budgetService.addBudget(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedBudget);
    }

    // Get All Budgets
    @GetMapping("/all")
    public ResponseEntity<List<BudgetDTO>> getAllBudgets() {

        List<BudgetDTO> budgets = budgetService.getAllBudgets();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(budgets);
    }

    // Delete Budget
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteBudget(@PathVariable Long id) {

        budgetService.deleteBudget(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Budget deleted successfully");
    }
}
package com.spring.smartexpense.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.ApiResponse;
import com.spring.smartexpense.dto.ExpenseDTO;
import com.spring.smartexpense.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse
    <ExpenseDTO>> addExpense(@RequestBody ExpenseDTO dto) {

        ExpenseDTO saved = expenseService.addExpense(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "Expense added successfully", saved));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<ExpenseDTO>>> getAllExpenses() {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Expenses fetched successfully",
                        expenseService.getAllExpenses()));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteExpense(@PathVariable Long id) {

        expenseService.deleteExpense(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Expense deleted successfully", null));
    }

    @GetMapping("/filter")
    public ResponseEntity<ApiResponse<List<ExpenseDTO>>> filterExpenses(
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) java.time.LocalDate startDate,
            @RequestParam(required = false) java.time.LocalDate endDate) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Filtered expenses fetched successfully",
                        expenseService.filterExpenses(categoryId, userId, startDate, endDate)));
    }
}
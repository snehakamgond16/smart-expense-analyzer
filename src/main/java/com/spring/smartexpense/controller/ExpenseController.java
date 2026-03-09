package com.spring.smartexpense.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.ExpenseDTO;
import com.spring.smartexpense.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Add Expense
    @PostMapping("/add")
    public ResponseEntity<ExpenseDTO> addExpense(@RequestBody ExpenseDTO dto) {

        ExpenseDTO savedExpense = expenseService.addExpense(dto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedExpense);
    }

    // Get All Expenses
    @GetMapping("/all")
    public ResponseEntity<List<ExpenseDTO>> getAllExpenses() {

        List<ExpenseDTO> expenses = expenseService.getAllExpenses();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(expenses);
    }

    // Delete Expense
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {

        expenseService.deleteExpense(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Expense deleted successfully");
    }
    
    @GetMapping("/filter")
    public ResponseEntity<List<ExpenseDTO>> filterExpenses(

            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Long userId,
            @RequestParam(required = false) LocalDate startDate,
            @RequestParam(required = false) LocalDate endDate) {

        List<ExpenseDTO> expenses =
                expenseService.filterExpenses(categoryId, userId, startDate, endDate);

        return ResponseEntity.ok(expenses);
    }
}
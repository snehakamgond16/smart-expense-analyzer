package com.spring.smartexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.entity.Expense;
import com.spring.smartexpense.service.ExpenseService;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    // Add Expense
    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody Expense expense) {

        Expense savedExpense = expenseService.addExpense(expense);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedExpense);
    }

    // Get All Expenses
    @GetMapping("/all")
    public ResponseEntity<List<Expense>> getAllExpenses() {

        List<Expense> expenses = expenseService.getAllExpenses();

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

}
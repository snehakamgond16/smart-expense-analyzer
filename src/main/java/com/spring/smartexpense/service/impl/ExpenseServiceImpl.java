package com.spring.smartexpense.service.impl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.smartexpense.dto.ExpenseDTO;
import com.spring.smartexpense.entity.Category;
import com.spring.smartexpense.entity.Expense;
import com.spring.smartexpense.entity.User;
import com.spring.smartexpense.repository.CategoryRepository;
import com.spring.smartexpense.repository.ExpenseRepository;
import com.spring.smartexpense.repository.UserRepository;
import com.spring.smartexpense.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    // Add Expense
    @Override
    public ExpenseDTO addExpense(ExpenseDTO dto) {

        Expense expense = new Expense();

        expense.setAmount(dto.getAmount());
        expense.setDescription(dto.getDescription());
        expense.setDate(dto.getDate());

        Category category = categoryRepository
                .findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        User user = userRepository
                .findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        expense.setCategory(category);
        expense.setUser(user);

        Expense savedExpense = expenseRepository.save(expense);

        ExpenseDTO response = new ExpenseDTO();

        response.setId(savedExpense.getId());
        response.setAmount(savedExpense.getAmount());
        response.setDescription(savedExpense.getDescription());
        response.setDate(savedExpense.getDate());
        response.setCategoryId(savedExpense.getCategory().getId());
        response.setUserId(savedExpense.getUser().getId());

        return response;
    }

    // Get All Expenses
    @Override
    public List<ExpenseDTO> getAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();

        return expenses.stream().map(expense -> {

            ExpenseDTO dto = new ExpenseDTO();

            dto.setId(expense.getId());
            dto.setAmount(expense.getAmount());
            dto.setDescription(expense.getDescription());
            dto.setDate(expense.getDate());
            dto.setCategoryId(expense.getCategory().getId());
            dto.setUserId(expense.getUser().getId());

            return dto;

        }).collect(Collectors.toList());
    }

    // Delete Expense
    @Override
    public void deleteExpense(Long id) {

        if (!expenseRepository.existsById(id)) {
            throw new RuntimeException("Expense not found");
        }

        expenseRepository.deleteById(id);
    }
    
    @Override
    public List<ExpenseDTO> filterExpenses(Long categoryId,
                                           Long userId,
                                           LocalDate startDate,
                                           LocalDate endDate) {

        List<Expense> expenses;

        if (categoryId != null) {
            expenses = expenseRepository.findByCategoryId(categoryId);
        }

        else if (userId != null) {
            expenses = expenseRepository.findByUserId(userId);
        }

        else if (startDate != null && endDate != null) {
            expenses = expenseRepository.findByDateBetween(startDate, endDate);
        }

        else {
            expenses = expenseRepository.findAll();
        }

        return expenses.stream().map(expense -> {

            ExpenseDTO dto = new ExpenseDTO();
            dto.setId(expense.getId());
            dto.setAmount(expense.getAmount());
            dto.setDescription(expense.getDescription());
            dto.setDate(expense.getDate());
            dto.setCategoryId(expense.getCategory().getId());
            dto.setUserId(expense.getUser().getId());

            return dto;

        }).toList();
    }

}
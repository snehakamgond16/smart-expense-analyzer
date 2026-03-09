package com.spring.smartexpense.service;

import java.time.LocalDate;
import java.util.List;

import com.spring.smartexpense.dto.ExpenseDTO;
import com.spring.smartexpense.entity.Expense;

public interface ExpenseService {

    ExpenseDTO addExpense(ExpenseDTO expense);

    List<ExpenseDTO> getAllExpenses();

    void deleteExpense(Long id);

    List<ExpenseDTO> filterExpenses(Long categoryId,
            Long userId,
            LocalDate startDate,
            LocalDate endDate);
}
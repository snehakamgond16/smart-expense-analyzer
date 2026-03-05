package com.spring.smartexpense.service;

import java.util.List;

import com.spring.smartexpense.dto.ExpenseDTO;
import com.spring.smartexpense.entity.Expense;

public interface ExpenseService {

    ExpenseDTO addExpense(ExpenseDTO expense);

    List<ExpenseDTO> getAllExpenses();

    void deleteExpense(Long id);

}
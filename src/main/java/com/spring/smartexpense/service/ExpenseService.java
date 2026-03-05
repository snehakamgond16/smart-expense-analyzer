package com.spring.smartexpense.service;

import java.util.List;
import com.spring.smartexpense.entity.Expense;

public interface ExpenseService {

    Expense addExpense(Expense expense);

    List<Expense> getAllExpenses();

    void deleteExpense(Long id);

}
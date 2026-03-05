package com.spring.smartexpense.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.smartexpense.entity.Expense;
import com.spring.smartexpense.repository.ExpenseRepository;
import com.spring.smartexpense.service.ExpenseService;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

}
package com.spring.smartexpense.service.impl;

import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.smartexpense.entity.Expense;
import com.spring.smartexpense.repository.ExpenseRepository;
import com.spring.smartexpense.service.AnalyticsService;

@Service
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    private ExpenseRepository expenseRepository;

    // Category wise expense summary
    @Override
    public Map<String, Double> getCategoryWiseExpenses(Long userId) {

        List<Expense> expenses = expenseRepository.findByUserId(userId);

        Map<String, Double> summary = new HashMap<>();

        for (Expense expense : expenses) {

            String categoryName = expense.getCategory().getName();

            summary.put(
                categoryName,
                summary.getOrDefault(categoryName, 0.0) + expense.getAmount()
            );
        }

        return summary;
    }

    // Monthly expense summary
    @Override
    public Map<String, Double> getMonthlyExpenses(Long userId) {

        List<Expense> expenses = expenseRepository.findByUserId(userId);

        Map<String, Double> summary = new HashMap<>();

        for (Expense expense : expenses) {

            int monthNumber = expense.getDate().getMonthValue();
            String monthName = Month.of(monthNumber).name();

            summary.put(
                monthName,
                summary.getOrDefault(monthName, 0.0) + expense.getAmount()
            );
        }

        return summary;
    }
}
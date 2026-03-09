package com.spring.smartexpense.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.smartexpense.dto.BudgetDTO;
import com.spring.smartexpense.entity.Budget;
import com.spring.smartexpense.entity.User;
import com.spring.smartexpense.repository.BudgetRepository;
import com.spring.smartexpense.repository.UserRepository;
import com.spring.smartexpense.service.BudgetService;

@Service
public class BudgetServiceImpl implements BudgetService {

    @Autowired
    private BudgetRepository budgetRepository;

    @Autowired
    private UserRepository userRepository;

    // Add Budget
    @Override
    public BudgetDTO addBudget(BudgetDTO dto) {

        Budget budget = new Budget();

        budget.setAmount(dto.getAmount());
        budget.setMonth(dto.getMonth());
        budget.setYear(dto.getYear());

        User user = userRepository
                .findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        budget.setUser(user);

        Budget savedBudget = budgetRepository.save(budget);

        BudgetDTO response = new BudgetDTO();
        response.setId(savedBudget.getId());
        response.setAmount(savedBudget.getAmount());
        response.setMonth(savedBudget.getMonth());
        response.setYear(savedBudget.getYear());
        response.setUserId(savedBudget.getUser().getId());

        return response;
    }

    // Get All Budgets
    @Override
    public List<BudgetDTO> getAllBudgets() {

        List<Budget> budgets = budgetRepository.findAll();

        return budgets.stream().map(budget -> {

            BudgetDTO dto = new BudgetDTO();
            dto.setId(budget.getId());
            dto.setAmount(budget.getAmount());
            dto.setMonth(budget.getMonth());
            dto.setYear(budget.getYear());
            dto.setUserId(budget.getUser().getId());

            return dto;

        }).collect(Collectors.toList());
    }

    // Delete Budget
    @Override
    public void deleteBudget(Long id) {

        if (!budgetRepository.existsById(id)) {
            throw new RuntimeException("Budget not found");
        }

        budgetRepository.deleteById(id);
    }
}
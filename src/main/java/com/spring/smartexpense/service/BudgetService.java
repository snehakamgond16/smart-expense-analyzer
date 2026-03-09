package com.spring.smartexpense.service;

import java.util.List;
import com.spring.smartexpense.dto.BudgetDTO;

public interface BudgetService {

    BudgetDTO addBudget(BudgetDTO dto);

    List<BudgetDTO> getAllBudgets();

    void deleteBudget(Long id);

}
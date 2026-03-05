package com.spring.smartexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.smartexpense.entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

}
package com.spring.smartexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.smartexpense.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
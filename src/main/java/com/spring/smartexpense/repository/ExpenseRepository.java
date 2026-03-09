package com.spring.smartexpense.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.smartexpense.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    List<Expense> findByCategoryId(Long categoryId);

    List<Expense> findByUserId(Long userId);

    List<Expense> findByDateBetween(LocalDate startDate, LocalDate endDate);

}
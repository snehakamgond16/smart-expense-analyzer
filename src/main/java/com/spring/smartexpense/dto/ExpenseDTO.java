package com.spring.smartexpense.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ExpenseDTO {

    private Long id;

    private Double amount;

    private String description;

    private LocalDate date;

    private Long categoryId;

    private Long userId;

}
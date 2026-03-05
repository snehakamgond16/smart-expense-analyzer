package com.spring.smartexpense.dto;

import lombok.Data;

@Data
public class BudgetDTO {

    private Long id;

    private Double amount;

    private Long categoryId;

    private Long userId;

}
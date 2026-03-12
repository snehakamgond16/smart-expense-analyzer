package com.spring.smartexpense.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.ApiResponse;
import com.spring.smartexpense.service.AnalyticsService;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    @GetMapping("/category-summary")
    public ResponseEntity<ApiResponse<java.util.Map<String, Double>>> categorySummary(
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Category summary fetched successfully",
                        analyticsService.getCategoryWiseExpenses(userId)));
    }

    @GetMapping("/monthly-summary")
    public ResponseEntity<ApiResponse<java.util.Map<String, Double>>> monthlySummary(
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Monthly summary fetched successfully",
                        analyticsService.getMonthlyExpenses(userId)));
    }
}
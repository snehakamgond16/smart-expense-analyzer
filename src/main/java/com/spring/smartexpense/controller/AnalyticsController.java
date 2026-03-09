package com.spring.smartexpense.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.service.AnalyticsService;

@RestController
@RequestMapping("/api/analytics")
public class AnalyticsController {

    @Autowired
    private AnalyticsService analyticsService;

    // Category wise summary
    @GetMapping("/category-summary")
    public ResponseEntity<Map<String, Double>> getCategorySummary(
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                analyticsService.getCategoryWiseExpenses(userId));
    }

    // Monthly summary
    @GetMapping("/monthly-summary")
    public ResponseEntity<Map<String, Double>> getMonthlySummary(
            @RequestParam Long userId) {

        return ResponseEntity.ok(
                analyticsService.getMonthlyExpenses(userId));
    }
}
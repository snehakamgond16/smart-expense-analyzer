package com.spring.smartexpense.service;

import java.util.Map;

public interface AnalyticsService {

    Map<String, Double> getCategoryWiseExpenses(Long userId);

    Map<String, Double> getMonthlyExpenses(Long userId);

}
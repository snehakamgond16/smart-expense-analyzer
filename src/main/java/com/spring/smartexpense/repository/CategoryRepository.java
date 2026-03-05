package com.spring.smartexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.smartexpense.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
package com.spring.smartexpense.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.spring.smartexpense.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
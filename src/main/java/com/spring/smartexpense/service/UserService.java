package com.spring.smartexpense.service;

import java.util.List;
import com.spring.smartexpense.entity.User;

public interface UserService {

    User createUser(User user);

    List<User> getAllUsers();

    User getUserById(Long id);

    void deleteUser(Long id);

}
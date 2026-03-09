package com.spring.smartexpense.service;

import java.util.List;
import com.spring.smartexpense.dto.UserDTO;

public interface UserService {

    UserDTO registerUser(UserDTO dto);

    List<UserDTO> getAllUsers();

    UserDTO getUserById(Long id);

    void deleteUser(Long id);

}
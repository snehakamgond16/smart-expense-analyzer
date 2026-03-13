package com.spring.smartexpense.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.smartexpense.dto.ApiResponse;
import com.spring.smartexpense.dto.LoginRequestDTO;
import com.spring.smartexpense.dto.UserDTO;
import com.spring.smartexpense.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserDTO>> registerUser(@RequestBody UserDTO dto) {

        UserDTO saved = userService.registerUser(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(true, "User registered successfully", saved));
    }

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<UserDTO>>> getAllUsers() {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "Users fetched successfully",
                        userService.getAllUsers()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<UserDTO>> getUserById(@PathVariable Long id) {

        return ResponseEntity.ok(
                new ApiResponse<>(true, "User fetched successfully",
                        userService.getUserById(id)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteUser(@PathVariable Long id) {

        userService.deleteUser(id);

        return ResponseEntity.ok(
                new ApiResponse<>(true, "User deleted successfully", null));
    }
    
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDTO request) {

        UserDTO user = userService.login(
                request.getEmail(),
                request.getPassword()
        );

        return ResponseEntity.ok(user);
    }
}
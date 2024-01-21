package com.simple.simplespringboot.controller;

import com.simple.simplespringboot.mapper.UserMapper;
import com.simple.simplespringboot.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<UserResource>> getAll() {
        return ResponseEntity.ok(this.userMapper.toResources(this.userService.getAll()));
    }

}

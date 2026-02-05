package com.gamertings.backend.controller;

import com.gamertings.backend.repository.UserRepository;
import com.gamertings.backend.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Anzahl gefundener User im Backend: " + users.size());
        return userRepository.findAll();
    }
}

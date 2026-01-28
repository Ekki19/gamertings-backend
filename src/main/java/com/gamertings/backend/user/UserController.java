package com.gamertings.backend.user;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000") // erlaubt React-Frontend
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        System.out.println("Anzahl gefundener User im Backend: " + users.size()); // Schau in die Docker-Logs
        return userRepository.findAll();
    }
}

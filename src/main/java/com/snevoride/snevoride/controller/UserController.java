package com.snevoride.snevoride.controller;

import com.snevoride.snevoride.entity.User;
import com.snevoride.snevoride.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 🟢 Register User (JSON)
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("Email already exists");
        }
        return ResponseEntity.ok(userRepository.save(user));
    }

    // 🟢 Login User (JSON)
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        return ResponseEntity.ok("Login success for: " + email);
    }

    // 🟢 Update User Location (JSON)
    @PostMapping("/update-location")
    public ResponseEntity<?> updateLocation(@RequestBody User req) {
        User user = userRepository.findById(req.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setLatitude(req.getLatitude());
        user.setLongitude(req.getLongitude());

        userRepository.save(user);

        return ResponseEntity.ok("User location updated");
    }

    // 🟢 Get All Users
    @GetMapping
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {

        return userRepository.findById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404)
                        .body(Map.of(
                                "status", 404,
                                "message", "User not found"
                        )));
    }



}

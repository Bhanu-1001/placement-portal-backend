package com.placement.portal.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.portal.model.User;
import com.placement.portal.repository.UserRepository;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private UserRepository userRepo;
    
    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody User user) {
        Map<String, Object> res = new HashMap<>();
        if(userRepo.findByUsername(user.getUsername()).isPresent()){
            res.put("success", false);
            res.put("message", "Username already exists");
            return res;
        }
        userRepo.save(user);
        res.put("success", true);
        res.put("message", "Registered as " + user.getRole());
        res.put("user", user);
        return res;
    }
    
    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody User loginUser) {
        Map<String, Object> res = new HashMap<>();
        Optional<User> user = userRepo.findByUsername(loginUser.getUsername());
        if(user.isPresent() && user.get().getPassword().equals(loginUser.getPassword())){
            res.put("success", true);
            res.put("user", user.get());
        } else {
            res.put("success", false);
            res.put("message", "Invalid credentials");
        }
        return res;
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}
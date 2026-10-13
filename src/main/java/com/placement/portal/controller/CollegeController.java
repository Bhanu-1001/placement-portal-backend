package com.placement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.portal.model.College;
import com.placement.portal.repository.CollegeRepository;

@RestController
@RequestMapping("/api/colleges")
@CrossOrigin(origins = "*")
public class CollegeController {
    
    @Autowired
    private CollegeRepository collegeRepo;
    
    @PostMapping
    public College createCollege(@RequestBody College college) {
        return collegeRepo.save(college);
    }
    
    @GetMapping
    public List<College> getAllColleges() {
        return collegeRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public College getCollege(@PathVariable Long id) {
        return collegeRepo.findById(id).orElse(null);
    }
    
    @DeleteMapping("/{id}")
    public String deleteCollege(@PathVariable Long id) {
        collegeRepo.deleteById(id);
        return "College deleted";
    }
}
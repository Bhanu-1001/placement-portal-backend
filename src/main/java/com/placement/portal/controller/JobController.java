package com.placement.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.placement.portal.model.Job;
import com.placement.portal.repository.JobRepository;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobController {
    
    @Autowired
    private JobRepository jobRepo;
    
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepo.save(job);
    }
    
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }
    
    @GetMapping("/{id}")
    public Job getJob(@PathVariable Long id) {
        return jobRepo.findById(id).orElse(null);
    }
}
package com.placement.portal.controller;

import com.placement.portal.model.Application;
import com.placement.portal.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping
    public Application apply(@RequestBody Application app) {
        if(app.getStatus() == null) app.setStatus("APPLIED");
        return applicationRepository.save(app);
    }

    @GetMapping
    public List<Application> getAll() {
        return applicationRepository.findAll();
    }

    // NEW - Update Status to SELECTED / REJECTED
    @PutMapping("/{id}/status")
    public Application updateStatus(@PathVariable Long id, @RequestBody java.util.Map<String,String> body) {
        Application app = applicationRepository.findById(id).orElseThrow();
        app.setStatus(body.get("status"));
        return applicationRepository.save(app);
    }

    @GetMapping("/student/{studentId}")
    public List<Application> getByStudent(@PathVariable Long studentId) {
        return applicationRepository.findAll().stream()
            .filter(a -> a.getStudentId() != null && a.getStudentId().equals(studentId))
            .toList();
    }
}
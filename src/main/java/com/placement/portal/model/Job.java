package com.placement.portal.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String company;
    private String location;
    private String ctc;
    
    @Column(length = 1000)
    private String description;

    // Constructors
    public Job() {}

    public Job(String title, String company, String location, String ctc, String description) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.ctc = ctc;
        this.description = description;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getCompany() { return company; }
    public void setCompany(String company) { this.company = company; }
    
    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
    
    public String getCtc() { return ctc; }
    public void setCtc(String ctc) { this.ctc = ctc; }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
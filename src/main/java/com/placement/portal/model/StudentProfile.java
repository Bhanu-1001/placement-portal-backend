package com.placement.portal.model;
import jakarta.persistence.*;
@Entity
@Table(name = "student_profiles")
public class StudentProfile {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @OneToOne
 private User user;
 private String branch;
 private Double cgpa;
 @Column(length=1000)
 private String skills;
 private String resumePath;
 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
 public User getUser(){return user;}
 public void setUser(User u){this.user=u;}
 public String getBranch(){return branch;}
 public void setBranch(String s){this.branch=s;}
 public Double getCgpa(){return cgpa;}
 public void setCgpa(Double d){this.cgpa=d;}
 public String getSkills(){return skills;}
 public void setSkills(String s){this.skills=s;}
 public String getResumePath(){return resumePath;}
 public void setResumePath(String s){this.resumePath=s;}
}
package com.placement.portal.model;
import jakarta.persistence.*;
@Entity
@Table(name = "companies")
public class Company {
 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String companyName;
 private String website;
 private String hrName;
 @OneToOne
 private User recruiterUser;
 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
 public String getCompanyName(){return companyName;}
 public void setCompanyName(String s){this.companyName=s;}
 public String getWebsite(){return website;}
 public void setWebsite(String s){this.website=s;}
 public String getHrName(){return hrName;}
 public void setHrName(String s){this.hrName=s;}
 public User getRecruiterUser(){return recruiterUser;}
 public void setRecruiterUser(User u){this.recruiterUser=u;}
}
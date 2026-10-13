package com.placement.portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.portal.model.Company;
public interface CompanyRepository extends JpaRepository<Company, Long> {}
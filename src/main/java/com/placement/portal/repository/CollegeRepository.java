package com.placement.portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.portal.model.College;
public interface CollegeRepository extends JpaRepository<College, Long> {}
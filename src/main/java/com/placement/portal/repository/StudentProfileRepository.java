package com.placement.portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.portal.model.StudentProfile;
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Long> {}
package com.placement.portal.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.placement.portal.model.Application;
public interface ApplicationRepository extends JpaRepository<Application, Long> {}
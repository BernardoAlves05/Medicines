package com.MedPlan.Repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MedPlan.Models.Plans;

public interface PlansRepo extends JpaRepository<Plans, Long> {
    
    
    
}
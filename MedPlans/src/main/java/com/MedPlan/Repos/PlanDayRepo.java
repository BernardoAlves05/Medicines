package com.MedPlan.Repos;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MedPlan.Models.PlanDay;

public interface PlanDayRepo extends JpaRepository<PlanDay,Long> {
    
    public List<PlanDay> findAllByPlanDate(Date planDate);
    public List<PlanDay> findAllByPlansPlanId(Long planId);
    public List<PlanDay> findAllByMedsCategory(String category);
}

package com.MedPlan.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.MedPlan.Models.Meds;

public interface MedsRepo extends JpaRepository<Meds, Long> {

}
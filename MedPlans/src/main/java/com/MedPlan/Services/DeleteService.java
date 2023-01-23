package com.MedPlan.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import com.MedPlan.Repos.PlansRepo;

@Service
public class DeleteService {

    @Autowired
    private PlansRepo plansRepo;
    @Autowired
    private UpdateService updateService;

    public String deletePlans(@PathVariable long planId) {

        updateService.updatePills(planId);
        plansRepo.deleteById(planId);

        return "Deleted plans with Id: " + planId;
    }
    
}

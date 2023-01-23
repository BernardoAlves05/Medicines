package com.MedPlan.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MedPlan.Models.PlanDay;
import com.MedPlan.Models.Plans;
import com.MedPlan.Repos.PlanDayRepo;
import com.MedPlan.Repos.PlansRepo;
import com.MedPlan.Services.DeleteService;
import com.MedPlan.Services.SaveService;

@CrossOrigin(maxAge = 3600)
@RestController
public class Controller {


    @Autowired
    private PlanDayRepo planDayRepo;

    @Autowired
    private SaveService saveService;


    @Autowired
    private DeleteService deleteService;

    @Autowired
    private PlansRepo plansRepo;


    
    @GetMapping("/planDay")
    public List<PlanDay> getPlanDay() {

        return planDayRepo.findAll();

    }

    @GetMapping("/plan")
    public List<Plans> getPlans() {

        return plansRepo.findAll();

    }

    @PostMapping(value = "/plan/save")
    public String savePlans(@RequestBody List<PlanDay> plans) {

        return saveService.savePlans(plans);
    }
    @DeleteMapping("/plans/delete/{planId}")
    public String deletePlans(@PathVariable Long planId) {

        return deleteService.deletePlans(planId);
    }

    @GetMapping("/plans/get/id/{planId}")
    public List<PlanDay> getPlansByDate(@PathVariable Long planId) {

        return planDayRepo.findAllByPlansPlanId(planId);

    }

    @GetMapping("/plans/get/date/{planDate}")
    public List<PlanDay> getPlansByDate(@PathVariable Date planDate) {

        return planDayRepo.findAllByPlanDate(planDate);

    }

    @GetMapping("/plans/get/category/{category}")
    public List<PlanDay> getPlansByCategory(@PathVariable String category) {

        return planDayRepo.findAllByMedsCategory(category);

    }
}

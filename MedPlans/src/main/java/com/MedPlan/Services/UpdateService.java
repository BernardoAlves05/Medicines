package com.MedPlan.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedPlan.Models.Meds;
import com.MedPlan.Models.PlanDay;
import com.MedPlan.Repos.MedsRepo;
import com.MedPlan.Repos.PlanDayRepo;

@Service
public class UpdateService {

    @Autowired
    private MedsRepo medsRepo;
    @Autowired
    private PlanDayRepo planDayRepo;

    public Meds updatePills(Long planId) {
        Meds updatePlanDay = new Meds();
        List<PlanDay> planDay = planDayRepo.findAllByPlansPlanId(planId);
        for (int i = 0; i < planDay.size(); i++) {
            Long medsId = planDay.get(i).getMeds().getMedsId();
            int pillNumber = planDay.get(i).getMeds().getPillNumber();
            int medsToTake = planDay.get(i).getMedsToTake();
            int pillUpdate = pillNumber + medsToTake;
            updatePlanDay =  medsRepo.findById(medsId).get();
            updatePlanDay.setPillNumber(pillUpdate);

        }
        return updatePlanDay;
    }
    
}

package com.MedPlan.Services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MedPlan.Models.Meds;
import com.MedPlan.Models.PlanDay;
import com.MedPlan.Models.Plans;
import com.MedPlan.Repos.MedsRepo;
import com.MedPlan.Repos.PlanDayRepo;
import com.MedPlan.Repos.PlansRepo;

@Service
public class SaveService {
    @Autowired
    private MedsRepo medsRepo;

    @Autowired
    private PlansRepo plansRepo;

    @Autowired
    private PlanDayRepo planDayRepo;


    public String savePlans(List<PlanDay> plans) throws Error {
        Date firstDate = plans.get(0).getPlanDate();
        long todayMili = System.currentTimeMillis();
        long dateLimitMili = firstDate.getTime() + 604800000;
        long planId = plans.get(0).getPlans().getPlanId();
        Plans plansWithId = new Plans();
        plansWithId.setPlanId(planId);
        plansRepo.save(plansWithId);

        for (int i = 0; i < plans.size(); i++) {
            long planDateInMili = plans.get(i).getPlanDate().getTime();

            if (planDateInMili <= dateLimitMili && todayMili < planDateInMili) {

                PlanDay planDay = plans.get(i);
                long medsId = planDay.getMeds().getMedsId();
                int medsToTake = planDay.getMedsToTake();
                Meds updatePlanDay = medsRepo.findById(medsId).get();
                int pillNumber = updatePlanDay.getPillNumber();
                int pillUpdate = pillNumber - medsToTake;
                if (pillUpdate > 0) {
                    updatePlanDay.setPillNumber(pillUpdate);
                } else {
                    return "Error: No piils available (Existing Pills: " + pillNumber + ")";
                }
                planDayRepo.save(planDay);
            } else {
                return "Week time interval not correct/Invalid planId (only one plan can be saved)";
            }

        }

        return "Saved Successfully";
    }
    
}

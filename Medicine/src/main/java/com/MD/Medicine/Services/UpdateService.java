package com.MD.Medicine.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MD.Medicine.Models.Meds;
import com.MD.Medicine.Repo.MedsRepo;

@Service
public class UpdateService {

    @Autowired
    private MedsRepo medsRepo;


    public String updateMeds(long medsId, Meds meds) {
        Meds updatedMeds = medsRepo.findById(medsId).get();
        updatedMeds.setMedsName(meds.getMedsName());
        updatedMeds.setPrice(meds.getPrice());
        updatedMeds.setCategory(meds.getCategory());
        updatedMeds.setPillNumber(meds.getPillNumber());
        updatedMeds.setMedsDate(updatedMeds.getMedsDate());
        medsRepo.save(updatedMeds);

        return "Updated Successfully";
    }

    
}

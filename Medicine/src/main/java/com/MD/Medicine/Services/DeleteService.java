package com.MD.Medicine.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.MD.Medicine.Models.Meds;
import com.MD.Medicine.Repo.MedsRepo;


@Service
public class DeleteService {

    @Autowired
    private MedsRepo medsRepo;


    public String deleteMeds(@PathVariable long medsId) {
        Meds deleteMeds = medsRepo.findById(medsId).get();
        medsRepo.delete(deleteMeds);

        return "Deleted meds with id: " + medsId;
    }

    
}

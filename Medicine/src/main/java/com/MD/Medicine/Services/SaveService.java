package com.MD.Medicine.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MD.Medicine.Models.Meds;
import com.MD.Medicine.Repo.MedsRepo;

@Service
public class SaveService {

    @Autowired
    private MedsRepo medsRepo;

    public String saveMeds(Meds meds) {

        medsRepo.save(meds);

        return "Saved Successfully";

    }

}

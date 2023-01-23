package com.MD.Medicine.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.MD.Medicine.Models.Meds;
import com.MD.Medicine.Repo.MedsRepo;
import com.MD.Medicine.Services.DeleteService;
import com.MD.Medicine.Services.SaveService;
import com.MD.Medicine.Services.UpdateService;

@CrossOrigin(maxAge = 3600)
@RestController
public class Controller {

    @Autowired
    private MedsRepo medsRepo;

    @Autowired
    private SaveService saveService;

    @Autowired
    private UpdateService updateService;

    @Autowired
    private DeleteService deleteService;


    @GetMapping("/medicines")
    public List<Meds> getMedicine() {

        return medsRepo.findAll();

    }

    @PostMapping(value = "/medicines/save")
    public String saveMeds(@RequestBody Meds meds) {

        return saveService.saveMeds(meds);
    }

    @PutMapping(value = "/medicines/update/{id}")
    public String updateMeds(@PathVariable long id, @RequestBody Meds meds) {

        return updateService.updateMeds(id, meds);
    }

    @DeleteMapping("/medicines/delete/{medsId}")
    public String deleteMeds(@PathVariable long medsId) {

        return deleteService.deleteMeds(medsId);
    }


    @GetMapping("/medicines/get/category/{category}")
    public List<Meds> getMedsByCategory(@PathVariable String category) {

        return medsRepo.findAllByCategory(category);

    }

    @GetMapping("/medicines/get/name/{medsName}")
    public List<Meds> getMedsByName(@PathVariable String medsName) {

        return medsRepo.findAllByMedsName(medsName);

    }
}

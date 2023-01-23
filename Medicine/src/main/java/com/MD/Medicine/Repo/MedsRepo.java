package com.MD.Medicine.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.MD.Medicine.Models.Meds;

public interface MedsRepo extends JpaRepository<Meds,Long> {
    public List<Meds> findAllByCategory(String category);
    public List<Meds> findAllByMedsName(String medsName);
}

package com.MD.Medicine.Models;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "planDay")
@JsonIgnoreProperties(value = { "planDaysId" })
public class PlanDay {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long planDaysId;

    @Column
    private Date planDate;

    @Column
    private String weekday;

    @ManyToOne
    @JoinColumn(name = "planId", nullable = false)
    private Plans plans;

    @ManyToOne
    @JoinColumn(name = "medsId", nullable = false)
    private Meds meds;

    @Column
    private int medsToTake;
}


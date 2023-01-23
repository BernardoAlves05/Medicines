package com.MD.Medicine.Models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meds")
@JsonIgnoreProperties(value = { "days" })
public class Meds {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long medsId;

    @Column
    private String medsName;

    @Column
    private BigDecimal price;

    @Column
    private String category;

    @Column
    private int pillNumber;

    @Column
    @CreationTimestamp
    private LocalDate medsDate;

    @OneToMany(mappedBy = "meds", cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Set<PlanDay> days = new HashSet<PlanDay>();

}
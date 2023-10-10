package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class PatientNote extends Base {
    private String content;
    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonIgnore
    private Patient patient;
}

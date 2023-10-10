package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Data
@Entity
//Muayene
public class PatientExamination extends Base {
    private String patientcomplaint; //HastaŞikayeti
    private String doctordiagnosis;  //Doktor Teşhisi
    private String treatmentadministered; //uygulanan Tedavi

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;


}

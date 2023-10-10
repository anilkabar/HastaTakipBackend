package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class District extends Base{

    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id",referencedColumnName = "id")
    @JsonIgnore
    private City city;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    List<Village> villageList;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    List<Patient> patientList;

    @OneToMany(mappedBy = "district")
    @JsonIgnore
    List<Company> companyList;






}

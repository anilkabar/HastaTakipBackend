package com.hastatakip.entites.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Company extends Base {
    private String name;
    private String address;
    private String phone;
    private String taxAdministration;
    private String taxnumber;
    //private String Path;

    @ManyToOne
    @JoinColumn(name = "district_id",referencedColumnName = "id")
    @JsonIgnore
    private District district;


    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company", cascade = CascadeType.ALL)
    @JsonIgnore
    List<Doctor> doctorList;


    @OneToMany(mappedBy = "company")
    @JsonIgnore
    List<Patient> patientList;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    List<StockBrand> stockBrandList;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    List<Users> usersList;

    @OneToMany(mappedBy = "company")
    @JsonIgnore
    List<Stock> stockList;








}

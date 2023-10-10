package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "doctor")
public class Doctor extends Base {
    String name;
    String surname;
    String phone;
    String address;
    String email;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;




    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    List<Patient> patient;


    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    List<Meeting> meetingList;



}

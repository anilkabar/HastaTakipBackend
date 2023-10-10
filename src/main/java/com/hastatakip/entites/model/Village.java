package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Village extends Base {

    private String name;



    @ManyToOne
    @JoinColumn(name = "district_id",referencedColumnName = "id")
    @JsonIgnore
    private District district;



}

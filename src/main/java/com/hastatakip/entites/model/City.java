package com.hastatakip.entites.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
public class City extends Base{

    private String name;
    @OneToMany(mappedBy = "city")
    @JsonIgnore
    List<District> districtList;




}

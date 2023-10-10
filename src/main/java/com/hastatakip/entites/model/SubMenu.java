package com.hastatakip.entites.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class SubMenu extends Base {

    private String name;

    @ManyToOne
    @JoinColumn(name = "menu_id",referencedColumnName = "id")
    @JsonIgnore
    private Menu menu;

}

package com.hastatakip.entites.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Menu extends Base{

    private String name;
    private String icon;

    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    List<SubMenu> subMenuList;

}

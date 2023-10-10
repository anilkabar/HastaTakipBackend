package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class PageAdmin extends Base {


    private String name;
    private String controllerName;

    @OneToMany(mappedBy = "pageAdmin")
    //@JsonIgnore
    List<UserAuthority> userAuthorityList;

}

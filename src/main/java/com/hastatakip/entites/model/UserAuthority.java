package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class UserAuthority extends Base {

    @ManyToOne
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    @JsonIgnore
    private Users users;

    @ManyToOne
    @JoinColumn(name = "pageadmin_id",referencedColumnName = "id")
    @JsonIgnore
    private PageAdmin pageAdmin;



}

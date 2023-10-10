package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class Users extends Base {

    private String username;
    private String password;
    private Boolean isActive;
    private String nameandsurname;

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    List<UserAuthority> userAuthorityList;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    List<StockSale> stockSaleList;

    @OneToMany(mappedBy = "users")
    @JsonIgnore
    List<StockPayment> stockSaleTermDetailList;



}

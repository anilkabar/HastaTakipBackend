package com.hastatakip.entites.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class StockPayment extends Base{
    //ödenenMiktarı
    private Long paymentAmount;
    private Long paymentType;
    private String information;


    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonIgnore
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    @JsonIgnore
    private Users users;


}

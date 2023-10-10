package com.hastatakip.entites.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

//Stok Satış
@Data
@Entity
public class StockSale extends Base {

    //Stok satış fiyatı
    private Long salePrice;

    //Alış Fiyatı
    private Long buyPrice;

    //satış miktarı
    private String information;

    @ManyToOne
    @JoinColumn(name = "stock_id",referencedColumnName = "id")
    @JsonIgnore
    private Stock stock;

    @ManyToOne
    @JoinColumn(name = "users_id",referencedColumnName = "id")
    @JsonIgnore
    private Users users;

    @ManyToOne
    @JoinColumn(name = "patient_id",referencedColumnName = "id")
    @JsonIgnore
    private Patient patient;












}

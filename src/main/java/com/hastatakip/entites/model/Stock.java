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
public class Stock extends Base {

    private String serialNumber;
    //stock miktarı
    private Long stockAmount;
    private Long price;


    @ManyToOne
    @JoinColumn(name = "model_id",referencedColumnName = "id")
    @JsonIgnore
    private StockModel stockModel;

    @ManyToOne
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    @JsonIgnore
    private Company company;

    @OneToMany(mappedBy = "stock")
    @JsonIgnore
    List<StockSale> stockSaleList;


}

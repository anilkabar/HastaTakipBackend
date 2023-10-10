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
public class StockModel extends Base{

    String name;

    @ManyToOne
    @JoinColumn(name = "brand_id",referencedColumnName = "id")
    @JsonIgnore
    private StockBrand stockBrand;

    @OneToMany(mappedBy = "stockModel")
    @JsonIgnore
    List<Stock> stockList;


}

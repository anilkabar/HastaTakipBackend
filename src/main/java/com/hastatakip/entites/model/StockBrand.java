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
public class StockBrand extends Base {
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private Company company;

    @OneToMany(mappedBy = "stockBrand")
    @JsonIgnore
    List<StockModel> stockModelList;
}

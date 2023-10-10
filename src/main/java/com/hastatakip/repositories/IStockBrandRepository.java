package com.hastatakip.repositories;

import com.hastatakip.entites.model.StockBrand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStockBrandRepository extends JpaRepository<StockBrand,Long> {

    List<StockBrand> findAllByCompanyId(Long id);

}

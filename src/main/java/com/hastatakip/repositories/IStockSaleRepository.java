package com.hastatakip.repositories;

import com.hastatakip.entites.model.StockSale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStockSaleRepository extends JpaRepository<StockSale,Long> {

    List<StockSale> findAllByPatientId(Long id);
    List<StockSale> findAllByPatientCompanyId(Long id);
}

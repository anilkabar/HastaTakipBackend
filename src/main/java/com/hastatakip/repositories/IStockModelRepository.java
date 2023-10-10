package com.hastatakip.repositories;

import com.hastatakip.entites.model.StockModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStockModelRepository extends JpaRepository<StockModel,Long> {
}

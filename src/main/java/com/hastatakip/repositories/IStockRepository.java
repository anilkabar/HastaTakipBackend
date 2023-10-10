package com.hastatakip.repositories;

import com.hastatakip.entites.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IStockRepository extends JpaRepository<Stock,Long> {

    List<Stock> findAllByCompanyId(Long id);

}

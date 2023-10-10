package com.hastatakip.repositories;

import com.hastatakip.entites.model.StockPayment;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.List;

public interface IStockPaymentRepository extends JpaRepository<StockPayment,Long> {

    List<StockPayment> findAllByPatientId(Long id);
    List<StockPayment> findAllByPatientCompanyId(Long id);





}

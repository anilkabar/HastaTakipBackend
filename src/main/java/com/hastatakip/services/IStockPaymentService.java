package com.hastatakip.services;

import com.hastatakip.entites.dto.StockPaymentDto;
import com.hastatakip.entites.model.StockPayment;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IStockPaymentService extends IBaseService<StockPaymentDto>{

   Result<List<StockPaymentDto>> findAllByPatientId(Long id);
   Result<List<StockPaymentDto>> findAllByPatientCompanyId(Long id);
}

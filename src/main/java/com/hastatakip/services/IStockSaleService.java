package com.hastatakip.services;

import com.hastatakip.entites.dto.StockSaleDto;
import com.hastatakip.utils.Result;

import java.util.List;


public interface IStockSaleService extends IBaseService<StockSaleDto> {
    Result<List<StockSaleDto>> getAllByPatientId(Long id);
    Result<List<StockSaleDto>> findByPatientCompanyId(Long id);


}

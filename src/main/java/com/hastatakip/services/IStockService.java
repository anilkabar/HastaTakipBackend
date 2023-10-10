package com.hastatakip.services;

import com.hastatakip.entites.dto.StockDto;
import com.hastatakip.entites.model.Stock;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IStockService extends IBaseService<StockDto> {

    Result<List<StockDto>> stockGetAllCompanyId(Long id);
    List<Stock> stockDeneme();


}

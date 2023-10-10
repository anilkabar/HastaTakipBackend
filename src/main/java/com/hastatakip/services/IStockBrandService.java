package com.hastatakip.services;

import com.hastatakip.entites.dto.StockBrandDto;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IStockBrandService extends IBaseService<StockBrandDto>{

    Result<List<StockBrandDto>> stockBrandCompanyGetAll(Long id);

}

package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.StockModelDto;
import com.hastatakip.entites.model.StockModel;

import java.util.List;

public interface IStockModelDto {

    StockModelDto stockModelToStockModelDto(StockModel stockModel);
    StockModel stockModelDtoToStockModel(StockModelDto stockModelDto);

    List<StockModel> listStockModelDtoToStockModel(List<StockModelDto> stockModelDto);
    List<StockModelDto> listStockModelToStockModelDto(List<StockModel> stockModelList);
}

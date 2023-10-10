package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.StockDto;
import com.hastatakip.entites.model.Stock;

import java.util.List;

public interface IStockDto {
    StockDto stockToStockDto(Stock stock);
    Stock stockDtoToStock(StockDto stockDto);
    List<Stock> listStockDtoToStock(List<StockDto> stockDtoList);
    List<StockDto> listStockToStockDto(List<Stock> stockList);
}

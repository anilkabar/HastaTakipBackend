package com.hastatakip.entites.mappers;
import com.hastatakip.entites.dto.StockSaleDto;
import com.hastatakip.entites.model.StockSale;

import java.util.List;

public interface IStockSaleDto {


    StockSaleDto stockSaleToStockSaleDto(StockSale stockSale);
    StockSale stockSaleDtoToStockSale(StockSaleDto stockSaleDto);
    List<StockSale> listStockSaleDtoToStockSale(List<StockSaleDto> stockSaleDtoList);
    List<StockSaleDto> listStockSaleToStockSaleDto(List<StockSale> stockSaleList);



}

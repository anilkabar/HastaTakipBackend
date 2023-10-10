package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.StockPaymentDto;
import com.hastatakip.entites.model.Stock;
import com.hastatakip.entites.model.StockPayment;

import java.util.List;

public interface IStockPaymentDto  {

    StockPaymentDto stockPaymentToStockPaymentDto(StockPayment stockPayment);
    StockPayment stockPaymentDtoToStockPayment(StockPaymentDto stockPaymentDto);
    List<StockPayment> listStockPaymentDtoToStockPayment(List<StockPaymentDto> stockPaymentDtoList);
    List<StockPaymentDto> listStockPaymentToStockPaymentDto(List<StockPayment> stockPaymentList);
}

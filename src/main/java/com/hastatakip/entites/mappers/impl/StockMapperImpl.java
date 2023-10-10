package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.StockDto;
import com.hastatakip.entites.mappers.IStockDto;
import com.hastatakip.entites.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class StockMapperImpl implements IStockDto {

    @Autowired
    CompanyMapperImpl companyMapper;

    @Autowired
    StockModelMapperImpl stockModelMapper;

    @Override
    public StockDto stockToStockDto(Stock stock) {
        StockDto stockDto=new StockDto();
        stockDto.setId(stock.getId());
        stockDto.setDate(stock.getDate());
        stockDto.setSerialNumber(stock.getSerialNumber());
        stockDto.setPrice(stock.getPrice());
        stockDto.setStockAmount(stock.getStockAmount());
        stockDto.setCompanyDto(companyMapper.companyToCompanyDto(stock.getCompany()));
        stockDto.setStockModelDto(stockModelMapper.stockModelToStockModelDto(stock.getStockModel()));
        return stockDto;
    }

    @Override
    public Stock stockDtoToStock(StockDto stockDto) {
        Stock stock=new Stock();
        stock.setId(stockDto.getId());
        stock.setDate(stockDto.getDate());
        stock.setSerialNumber(stockDto.getSerialNumber());
        stock.setPrice(stockDto.getPrice());
        stock.setStockAmount(stockDto.getStockAmount());
        stock.setCompany(companyMapper.companyDtoToCompany(stockDto.getCompanyDto()));
        stock.setStockModel(stockModelMapper.stockModelDtoToStockModel(stockDto.getStockModelDto()));
        return stock;
    }

    @Override
    public List<Stock> listStockDtoToStock(List<StockDto> stockDtoList) {
        List<Stock> stockList=new ArrayList<>(stockDtoList.size());
        stockDtoList.forEach(item->{
            Stock stock=stockDtoToStock(item);
            stockList.add(stock);
        });
        return stockList;
    }

    @Override
    public List<StockDto> listStockToStockDto(List<Stock> stockList) {
        List<StockDto> stockDtoList=new ArrayList<>(stockList.size());
        stockList.forEach(item->{
            StockDto stockDto=stockToStockDto(item);
            stockDtoList.add(stockDto);
        });
        return stockDtoList;
    }
}

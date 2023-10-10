package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.StockSaleDto;
import com.hastatakip.entites.mappers.IStockSaleDto;
import com.hastatakip.entites.model.StockSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockSaleMapperImpl implements IStockSaleDto {

    @Autowired
    StockMapperImpl stockMapper;

    @Autowired
    UsersMapperImpl usersMapper;

    @Autowired
    PatientMapperImpl patientMapper;

    @Override
    public StockSaleDto stockSaleToStockSaleDto(StockSale stockSale) {

        StockSaleDto stockSaleDto=new StockSaleDto();
        stockSaleDto.setId(stockSale.getId());
        stockSaleDto.setDate(stockSale.getDate());
        stockSaleDto.setInformation(stockSale.getInformation());
        //stockSaleDto.setPrice(stockSale.getSalePrice());
        stockSaleDto.setSalePrice(stockSale.getSalePrice());
        stockSaleDto.setBuyPrice(stockSale.getBuyPrice());
        stockSaleDto.setStockDto(stockMapper.stockToStockDto(stockSale.getStock()));
        stockSaleDto.setUsersDto(usersMapper.usersToUsersDto(stockSale.getUsers()));
        stockSaleDto.setPatientDto(patientMapper.patientToPatientDto(stockSale.getPatient()));
        return stockSaleDto;
    }

    @Override
    public StockSale stockSaleDtoToStockSale(StockSaleDto stockSaleDto) {
        if (stockSaleDto==null){
            return null;
        }
        StockSale stockSale=new StockSale();
        stockSale.setId(stockSaleDto.getId());
        stockSale.setDate(stockSaleDto.getDate());
        stockSale.setInformation(stockSaleDto.getInformation());
        stockSale.setSalePrice(stockSaleDto.getSalePrice());
        stockSale.setBuyPrice(stockSaleDto.getBuyPrice());
        stockSale.setStock(stockMapper.stockDtoToStock(stockSaleDto.getStockDto()));
        stockSale.setUsers(usersMapper.usersDtoToUsers(stockSaleDto.getUsersDto()));
        stockSale.setPatient(patientMapper.patientDtoTopatient(stockSaleDto.getPatientDto()));
        return stockSale;
    }

    @Override
    public List<StockSale> listStockSaleDtoToStockSale(List<StockSaleDto> stockSaleDtoList) {

        List<StockSale> stockSaleList=new ArrayList<>(stockSaleDtoList.size());
        stockSaleDtoList.forEach(item->{
            StockSale stockSale=stockSaleDtoToStockSale(item);
            stockSaleList.add(stockSale);
        });
        return stockSaleList;
    }

    @Override
    public List<StockSaleDto> listStockSaleToStockSaleDto(List<StockSale> stockSaleList) {

        List<StockSaleDto> stockSaleDtoList=new ArrayList<>(stockSaleList.size());
        stockSaleList.forEach(item->{
            StockSaleDto stockSaleDto=stockSaleToStockSaleDto(item);
            stockSaleDtoList.add(stockSaleDto);
        });

        return stockSaleDtoList;
    }
}

package com.hastatakip.entites.mappers.impl;


import com.hastatakip.entites.dto.StockPaymentDto;
import com.hastatakip.entites.mappers.IStockPaymentDto;
import com.hastatakip.entites.model.Stock;
import com.hastatakip.entites.model.StockPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class StockPaymentMapperImpl implements IStockPaymentDto {

    @Autowired
    StockSaleMapperImpl stockSaleMapper;

    @Autowired
    PatientMapperImpl patientMapper;

    @Autowired
    UsersMapperImpl usersMapper;

    @Override
    public StockPaymentDto stockPaymentToStockPaymentDto(StockPayment stockPayment) {
        if (stockPayment==null)
        {
            return null;
        }
        StockPaymentDto stockPaymentDto=new StockPaymentDto();
        stockPaymentDto.setId(stockPayment.getId());
        stockPaymentDto.setDate(stockPayment.getDate());
        stockPaymentDto.setPaymentAmount(stockPayment.getPaymentAmount());
        stockPaymentDto.setPaymentType(stockPayment.getPaymentType());
        stockPaymentDto.setInformation(stockPayment.getInformation());
        //stockPaymentDto.setStockSaleDto(stockSaleMapper.stockSaleToStockSaleDto(stockPayment.getStockSale()));
        stockPaymentDto.setPatientDto(patientMapper.patientToPatientDto(stockPayment.getPatient()));
        stockPaymentDto.setUsersDto(usersMapper.usersToUsersDto(stockPayment.getUsers()));
        return stockPaymentDto;
    }

    @Override
    public StockPayment stockPaymentDtoToStockPayment(StockPaymentDto stockPaymentDto) {
        StockPayment stockPayment=new StockPayment();
        stockPayment.setId(stockPaymentDto.getId());
        stockPayment.setDate(stockPaymentDto.getDate());
        stockPayment.setPaymentAmount(stockPaymentDto.getPaymentAmount());
        stockPayment.setPaymentType(stockPaymentDto.getPaymentType());
        stockPayment.setInformation(stockPaymentDto.getInformation());
        stockPayment.setUsers(usersMapper.usersDtoToUsers(stockPaymentDto.getUsersDto()));
        //stockPayment.setStockSale(stockSaleMapper.stockSaleDtoToStockSale(stockPaymentDto.getStockSaleDto()));
        stockPayment.setPatient(patientMapper.patientDtoTopatient(stockPaymentDto.getPatientDto()));

        return stockPayment;
    }

    @Override
    public List<StockPayment> listStockPaymentDtoToStockPayment(List<StockPaymentDto> stockPaymentDtoList) {
        List<StockPayment> stockPaymentList=new ArrayList<>(stockPaymentDtoList.size());
        stockPaymentDtoList.forEach(item->{
            StockPayment stockPayment=stockPaymentDtoToStockPayment(item);
            stockPaymentList.add(stockPayment);
        });

        return stockPaymentList;
    }

    @Override
    public List<StockPaymentDto> listStockPaymentToStockPaymentDto(List<StockPayment> stockPaymentList) {
        List<StockPaymentDto> stockPaymentDtoList=new ArrayList<>(stockPaymentList.size());
        stockPaymentList.forEach(item->{
            StockPaymentDto stockPaymentDto=stockPaymentToStockPaymentDto(item);
            stockPaymentDtoList.add(stockPaymentDto);
        });

        return stockPaymentDtoList;
    }
}

package com.hastatakip.entites.mappers.impl;


import com.hastatakip.entites.dto.PatientNoteDto;
import com.hastatakip.entites.dto.StockBrandDto;
import com.hastatakip.entites.mappers.IStockBrandDto;
import com.hastatakip.entites.model.Stock;
import com.hastatakip.entites.model.StockBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockBrandMapperImpl implements IStockBrandDto {

    @Autowired
    private CompanyMapperImpl companyMapper;


    @Override
    public StockBrandDto stockBrandToStockBrandDto(StockBrand stockBrand) {
        StockBrandDto stockBrandDto=new StockBrandDto();
        stockBrandDto.setId(stockBrand.getId());
        stockBrandDto.setName(stockBrand.getName());
        stockBrandDto.setDate(stockBrand.getDate());
        return stockBrandDto;
    }

    @Override
    public StockBrand stockBrandDtoToStockBrand(StockBrandDto stockBrandDto) {
        StockBrand stockBrand=new StockBrand();
        stockBrand.setId(stockBrandDto.getId());
        stockBrand.setName(stockBrandDto.getName());
        stockBrand.setDate(stockBrandDto.getDate());
        //stockBrand.setCompany(companyMapper.companyDtoToCompany(stockBrandDto.getCompanyDto()));
        return stockBrand;
    }

    @Override
    public List<StockBrand> listStockBrandDtoToStockBrand(List<StockBrandDto> stockBrandDto) {
        List<StockBrand> stockBrandList=new ArrayList<>(stockBrandDto.size());
        stockBrandDto.forEach(item->{
            StockBrand stockBrand=stockBrandDtoToStockBrand(item);
            stockBrandList.add(stockBrand);
        });
        return stockBrandList;
    }

    @Override
    public List<StockBrandDto> listStockBrandToStockBrandDto(List<StockBrand> stockBrand) {

        List<StockBrandDto> stockBrandDtoList=new ArrayList<>(stockBrand.size());
        stockBrand.forEach(item->{
            StockBrandDto stockBrandDto=stockBrandToStockBrandDto(item);
            stockBrandDtoList.add(stockBrandDto);
        });

        return stockBrandDtoList;
    }
}

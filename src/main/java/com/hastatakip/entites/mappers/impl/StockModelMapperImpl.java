package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.StockModelDto;
import com.hastatakip.entites.mappers.IStockModelDto;
import com.hastatakip.entites.model.StockModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StockModelMapperImpl implements IStockModelDto {

    @Autowired
    StockBrandMapperImpl stockBrandMapper;


    @Override
    public StockModelDto stockModelToStockModelDto(StockModel stockModel) {
        StockModelDto stockModelDto=new StockModelDto();
        stockModelDto.setId(stockModel.getId());
        stockModelDto.setName(stockModel.getName());
        stockModelDto.setDate(stockModel.getDate());
        stockModelDto.setStockBrandDto(stockBrandMapper.stockBrandToStockBrandDto(stockModel.getStockBrand()));
        return stockModelDto;
    }

    @Override
    public StockModel stockModelDtoToStockModel(StockModelDto stockModelDto) {

        StockModel stockModel=new StockModel();
        stockModel.setId(stockModelDto.getId());
        stockModel.setName(stockModelDto.getName());
        stockModel.setDate(stockModelDto.getDate());
        stockModel.setStockBrand(stockBrandMapper.stockBrandDtoToStockBrand(stockModelDto.getStockBrandDto()));
        return stockModel;
    }

    @Override
    public List<StockModel> listStockModelDtoToStockModel(List<StockModelDto> stockModelDto) {

        List<StockModel> stockModelList=new ArrayList<>(stockModelDto.size());
        stockModelDto.forEach(item->{
            StockModel stockModel=stockModelDtoToStockModel(item);
            stockModelList.add(stockModel);
        });

        return stockModelList;
    }

    @Override
    public List<StockModelDto> listStockModelToStockModelDto(List<StockModel> stockModelList) {
        List<StockModelDto> stockModelDtoList=new ArrayList<>(stockModelList.size());
        stockModelList.forEach(item->{
            StockModelDto stockModelDto=stockModelToStockModelDto(item);
            stockModelDtoList.add(stockModelDto);
        });
        return stockModelDtoList;
    }
}

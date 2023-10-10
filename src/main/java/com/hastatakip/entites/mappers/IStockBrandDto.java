package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.PatientNoteDto;
import com.hastatakip.entites.dto.StockBrandDto;
import com.hastatakip.entites.model.PatientNote;
import com.hastatakip.entites.model.StockBrand;

import java.util.List;

public interface IStockBrandDto {

    StockBrandDto stockBrandToStockBrandDto(StockBrand stockBrand);
    StockBrand stockBrandDtoToStockBrand(StockBrandDto stockBrandDto);

    List<StockBrand> listStockBrandDtoToStockBrand(List<StockBrandDto> stockBrandDto);
    List<StockBrandDto> listStockBrandToStockBrandDto(List<StockBrand> stockBrandList);
}

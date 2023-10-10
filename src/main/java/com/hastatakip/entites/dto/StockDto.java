package com.hastatakip.entites.dto;


import lombok.Data;

@Data
public class StockDto extends BaseDto implements IDto {
     String serialNumber;
    //stock miktarı
     Long stockAmount;
     Long price;
     CompanyDto companyDto;
     StockModelDto stockModelDto;
}

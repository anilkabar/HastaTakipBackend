package com.hastatakip.entites.dto;

import lombok.Data;

@Data
public class StockBrandDto extends BaseDto implements IDto {

    String name;
    CompanyDto companyDto;


}

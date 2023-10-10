package com.hastatakip.entites.dto;

import lombok.Data;

@Data
public class StockModelDto extends BaseDto implements IDto {

    String name;
    StockBrandDto stockBrandDto;


}

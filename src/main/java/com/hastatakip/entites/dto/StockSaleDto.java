package com.hastatakip.entites.dto;


import lombok.Data;

@Data
public class StockSaleDto extends BaseDto implements IDto {

    private Long salePrice;
    private Long buyPrice;
    private String information;
    private StockDto stockDto;
    private UsersDto usersDto;
    private PatientDto patientDto;

}

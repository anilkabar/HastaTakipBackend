package com.hastatakip.entites.dto;

import lombok.Data;


@Data
public class StockPaymentDto extends BaseDto implements IDto {
    Long paymentAmount;
    Long paymentType;
    String information;
    //StockSaleDto stockSaleDto;
    PatientDto patientDto;
    UsersDto usersDto;
}

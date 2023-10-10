package com.hastatakip.entites.dto;

import lombok.Data;

@Data
public class UsersDto extends BaseDto implements IDto {

    String username;
    String password;
    Boolean isActive;
    String nameandsurname;
    CompanyDto companyDto;

}

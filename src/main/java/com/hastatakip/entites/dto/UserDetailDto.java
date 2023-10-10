package com.hastatakip.entites.dto;


import lombok.Data;

@Data
public class UserDetailDto extends BaseDto implements IDto {
    String nameandsurname;
    Boolean isActive;
    String username;
}

package com.hastatakip.entites.dto;

import lombok.Data;


@Data
public class UserAuthorityDto extends BaseDto implements IDto {
    Long pageAdminId;
    Long userId;
    Boolean isActive;



}

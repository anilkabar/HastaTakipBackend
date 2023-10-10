package com.hastatakip.entites.dto;

import lombok.Data;

@Data
public class PageAdminDto extends BaseDto implements IDto {
     String name;
     String controllerName;
}

package com.hastatakip.entites.dto;

import com.hastatakip.entites.model.District;
import lombok.Data;


@Data
public class CompanyDto extends BaseDto implements IDto{

     String name;
     String address;
     String phone;
     String taxAdministration;
     String taxnumber;
     District district;

}

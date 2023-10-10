package com.hastatakip.entites.dto;

import com.hastatakip.entites.model.Company;
import lombok.Data;

@Data
public class DoctorDto extends BaseDto implements IDto {

    String name;
    String Surname;
    String phone;
    String address;
    String email;
    Company company;

}

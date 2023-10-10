package com.hastatakip.entites.dto;

import com.hastatakip.entites.model.*;
import com.hastatakip.utils.Enum.Gender;
import lombok.Data;

import java.io.File;
import java.util.Date;

@Data
public class PatientDto extends BaseDto implements IDto{

     String identificationNumber;
     String name;
     String surname;
     Date dateofBirth;
     String phone;
     String email;
     String adress;
     String imagePath;
     Gender gender;
     Company company;
     Doctor doctor;
     District districth;



}

package com.hastatakip.entites.dto;


import lombok.Data;

@Data
public class PatientDocumentDto extends BaseDto implements IDto {
    String name;
    String path;
    PatientDto patientDto;

}

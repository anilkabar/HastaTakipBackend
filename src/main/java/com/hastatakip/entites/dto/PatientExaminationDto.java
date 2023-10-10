package com.hastatakip.entites.dto;

import lombok.Data;

@Data
public class PatientExaminationDto extends BaseDto implements IDto {
    String doctorDiagnosis;
    String patientComplaint;
    String treatmentAdministered;
    PatientDto patientDto;
}

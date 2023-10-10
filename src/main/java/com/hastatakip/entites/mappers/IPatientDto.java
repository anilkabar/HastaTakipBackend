package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.PatientDto;
import com.hastatakip.entites.model.Patient;


import java.util.List;

public interface IPatientDto {

    PatientDto patientToPatientDto(Patient patient);
    Patient patientDtoTopatient(PatientDto doctorDto);

    List<Patient> listPatientDtoToPatient(List<PatientDto> patientDto);
    List<PatientDto> listPatientToPatientDto(List<Patient> patient);
}

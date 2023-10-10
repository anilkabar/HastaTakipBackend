package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.DoctorDto;
import com.hastatakip.entites.dto.PatientDocumentDto;
import com.hastatakip.entites.dto.PatientExaminationDto;
import com.hastatakip.entites.model.Doctor;
import com.hastatakip.entites.model.PatientExamination;

import java.util.List;

public interface IPatientExaminationDto {

    PatientExaminationDto patientExaminationToPatientExaminationDto(PatientExamination patientExamination);
    PatientExamination patientExaminationDtoToPatientExamination(PatientExaminationDto patientExaminationDto);

    List<PatientExamination> listPatientExaminationDtoToPatientExamination(List<PatientExaminationDto> patientExaminationDtoList);
    List<PatientExaminationDto> listPatientExaminationToPatientExaminationDto(List<PatientExamination> patientExaminationList);
}

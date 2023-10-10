package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.PatientDocumentDto;
import com.hastatakip.entites.dto.PatientExaminationDto;
import com.hastatakip.entites.mappers.IPatientExaminationDto;
import com.hastatakip.entites.model.PatientExamination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientExaminationMapperImpl implements IPatientExaminationDto {

    @Autowired
    PatientMapperImpl patientMapper;

    @Override
    public PatientExaminationDto patientExaminationToPatientExaminationDto(PatientExamination patientExamination) {
        PatientExaminationDto patientExaminationDto=new PatientExaminationDto();
        patientExaminationDto.setId(patientExamination.getId());
        patientExaminationDto.setDoctorDiagnosis(patientExamination.getDoctordiagnosis());
        patientExaminationDto.setPatientComplaint(patientExamination.getPatientcomplaint());
        patientExaminationDto.setTreatmentAdministered(patientExamination.getTreatmentadministered());
        patientExaminationDto.setDate(patientExamination.getDate());
        patientExaminationDto.setPatientDto(patientMapper.patientToPatientDto(patientExamination.getPatient()));
        return patientExaminationDto;
    }

    @Override
    public PatientExamination patientExaminationDtoToPatientExamination(PatientExaminationDto patientExaminationDto) {
        PatientExamination patientExamination=new PatientExamination();
        patientExamination.setId(patientExaminationDto.getId());
        patientExamination.setDoctordiagnosis(patientExaminationDto.getDoctorDiagnosis());
        patientExamination.setPatientcomplaint(patientExaminationDto.getPatientComplaint());
        patientExamination.setTreatmentadministered(patientExaminationDto.getTreatmentAdministered());
        patientExamination.setDate(patientExaminationDto.getDate());
        patientExamination.setPatient(patientMapper.patientDtoTopatient(patientExaminationDto.getPatientDto()));
        return patientExamination;
    }

    @Override
    public List<PatientExamination> listPatientExaminationDtoToPatientExamination(List<PatientExaminationDto> patientExaminationDtoList) {

        List<PatientExamination> patientExaminationList=new ArrayList<>(patientExaminationDtoList.size());
        patientExaminationDtoList.forEach(item->{
            PatientExamination patientExamination=patientExaminationDtoToPatientExamination(item);
            patientExaminationList.add(patientExamination);
        });
        return patientExaminationList;
    }

    @Override
    public List<PatientExaminationDto> listPatientExaminationToPatientExaminationDto(List<PatientExamination> patientExaminationList) {

        List<PatientExaminationDto> patientDocumentDtoList=new ArrayList<>(patientExaminationList.size());
        patientExaminationList.forEach(item->{
            PatientExaminationDto patientExaminationDto=patientExaminationToPatientExaminationDto(item);
            patientDocumentDtoList.add(patientExaminationDto);
        });

        return patientDocumentDtoList;
    }
}

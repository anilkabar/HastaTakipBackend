package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.PatientDto;
import com.hastatakip.entites.mappers.IPatientDto;
import com.hastatakip.entites.model.Patient;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientMapperImpl implements IPatientDto {

    @Override
    public PatientDto patientToPatientDto(Patient patient) {

        PatientDto patientDto=new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setIdentificationNumber(patient.getIdentificationNumber());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setDateofBirth(patient.getDateofBirth());
        patientDto.setDate(patient.getDate());
        patientDto.setPhone(patient.getPhone());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAdress(patient.getAdress());
        patientDto.setImagePath(patient.getImagePath());
        patientDto.setGender(patient.getGender());
        patientDto.setCompany(patient.getCompany());
        patientDto.setDoctor(patient.getDoctor());
        patientDto.setDistricth(patient.getDistrict());
        return patientDto;
    }

    @Override
    public Patient patientDtoTopatient(PatientDto patientDto) {
        Patient patient=new Patient();
        patient.setId(patientDto.getId());
        patient.setIdentificationNumber(patientDto.getIdentificationNumber());
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setDateofBirth(patientDto.getDateofBirth());
        patient.setDate(patientDto.getDate());
        patient.setPhone(patientDto.getPhone());
        patient.setEmail(patientDto.getEmail());
        patient.setAdress(patientDto.getAdress());
        patient.setImagePath(patientDto.getImagePath());
        patient.setGender(patientDto.getGender());
        patient.setCompany(patientDto.getCompany());
        patient.setDoctor(patientDto.getDoctor());
        patient.setDistrict(patientDto.getDistricth());
        return patient;
    }

    @Override
    public List<Patient> listPatientDtoToPatient(List<PatientDto> patientDto) {

        List<Patient> patientList=new ArrayList<>(patientDto.size());
        patientDto.forEach(item->{
            Patient patient=patientDtoTopatient(item);
            patientList.add(patient);
        });

        return patientList;
    }

    @Override
    public List<PatientDto> listPatientToPatientDto(List<Patient> patient) {

        List<PatientDto> patientDtoList=new ArrayList<>(patient.size());
        patient.forEach(item->{
            PatientDto patientDto=patientToPatientDto(item);
            patientDtoList.add(patientDto);
        });


        return patientDtoList;
    }
}

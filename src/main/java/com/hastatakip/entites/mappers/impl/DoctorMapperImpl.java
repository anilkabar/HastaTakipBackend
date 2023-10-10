package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.DoctorDto;
import com.hastatakip.entites.mappers.IDoctorDto;
import com.hastatakip.entites.model.Doctor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorMapperImpl implements IDoctorDto {
    @Override
    public DoctorDto doctorToDoctorDto(Doctor doctor) {
        if(doctor==null){
            return null;
        }
        DoctorDto doctorDto= new DoctorDto();
        doctorDto.setId(doctor.getId());
        doctorDto.setName(doctor.getName());
        doctorDto.setSurname(doctor.getSurname());
        doctorDto.setPhone(doctor.getPhone());
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setEmail(doctor.getEmail());
        doctorDto.setCompany(doctor.getCompany());
        return doctorDto;
    }

    @Override
    public Doctor doctorDtoTodoctor(DoctorDto doctorDto) {
        if (doctorDto==null){
            return null;
        }
        Doctor doctor=new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setPhone(doctorDto.getPhone());
        doctor.setAddress(doctorDto.getAddress());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setCompany(doctorDto.getCompany());

        return doctor;
    }

    @Override
    public List<Doctor> listDoctorDtoToDoctor(List<DoctorDto> doctorDto) {

        List<Doctor> doctorList=new ArrayList<>(doctorDto.size());
        doctorDto.forEach(item->{
            Doctor doctor=doctorDtoTodoctor(item);
            doctorList.add(doctor);
        });

        return doctorList;
    }

    @Override
    public List<DoctorDto> listDoctorToDoctorDto(List<Doctor> doctor) {
        List<DoctorDto> doctorDtoList=new ArrayList<>(doctor.size());
        doctor.forEach(item->{
            DoctorDto doctorDto=doctorToDoctorDto(item);
            doctorDtoList.add(doctorDto);
        });

        return doctorDtoList;
    }
}

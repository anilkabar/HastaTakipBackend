package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.DoctorDto;
import com.hastatakip.entites.model.Doctor;

import java.util.List;

public interface IDoctorDto {
    DoctorDto doctorToDoctorDto(Doctor doctor);
    Doctor doctorDtoTodoctor(DoctorDto doctorDto);

    List<Doctor> listDoctorDtoToDoctor(List<DoctorDto> doctorDto);
    List<DoctorDto> listDoctorToDoctorDto(List<Doctor> doctor);

}

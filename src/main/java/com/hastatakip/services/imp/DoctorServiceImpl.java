package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.DoctorDto;
import com.hastatakip.entites.mappers.impl.DoctorMapperImpl;
import com.hastatakip.entites.model.Doctor;
import com.hastatakip.repositories.IDoctorRepository;
import com.hastatakip.services.IDoctorService;
import com.hastatakip.utils.Result;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class DoctorServiceImpl implements IDoctorService {

    final MessageSourceAccessor messageSourceAccessor;
    final IDoctorRepository doctorRepository;
    final DoctorMapperImpl doctorMapper;

    public DoctorServiceImpl(MessageSourceAccessor messageSourceAccessor, IDoctorRepository doctorRepository, DoctorMapperImpl doctorMapper) {
        this.messageSourceAccessor = messageSourceAccessor;
        this.doctorRepository = doctorRepository;
        this.doctorMapper = doctorMapper;
    }


    @Override
    public Result<DoctorDto> save(DoctorDto doctorDto) {
        Date dt=new Date();
        Doctor doctor=doctorMapper.doctorDtoTodoctor(doctorDto);
        doctor=doctorRepository.save(doctor);
        doctorDto=doctorMapper.doctorToDoctorDto(doctor);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),doctorDto);
    }

    @Override
    public Result<DoctorDto> update(DoctorDto doctorDto) {
        return null;
    }

    @Override
    public Result<DoctorDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<DoctorDto>> getAll() {
        List<Doctor> doctorList=doctorRepository.findAll();
        List<DoctorDto> doctorDtoList=doctorMapper.listDoctorToDoctorDto(doctorList);
        return new Result<List<DoctorDto>>(true,messageSourceAccessor.getMessage("result.success"),doctorDtoList);
    }

    @Override
    public Result<DoctorDto> deleteById(Long id) {
        return null;
    }

    @Override
    public Result<List<DoctorDto>> getAllCompanyId(Long id) {
        List<Doctor> doctorList=doctorRepository.findAllByCompanyId(id);
        List<DoctorDto> doctorDtoList=doctorMapper.listDoctorToDoctorDto(doctorList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),doctorDtoList);
    }
}

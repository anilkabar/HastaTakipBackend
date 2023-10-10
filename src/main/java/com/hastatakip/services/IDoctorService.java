package com.hastatakip.services;

import com.hastatakip.entites.dto.DoctorDto;
import com.hastatakip.entites.model.Doctor;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IDoctorService extends IBaseService<DoctorDto>{

    Result<List<DoctorDto>> getAllCompanyId(Long id);

}

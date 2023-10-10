package com.hastatakip.services;

import com.hastatakip.entites.dto.PatientDto;
import com.hastatakip.entites.model.Patient;
import com.hastatakip.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IPatientService extends IBaseService<PatientDto>{

    Result<PatientDto> saveUpload(PatientDto patientDto,MultipartFile file);
    Result<List<PatientDto>> getAllById(String userName);

}

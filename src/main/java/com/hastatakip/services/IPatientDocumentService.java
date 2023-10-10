package com.hastatakip.services;

import com.hastatakip.entites.dto.PatientDocumentDto;
import com.hastatakip.utils.Result;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IPatientDocumentService extends IBaseService<PatientDocumentDto>{

   Result<List<PatientDocumentDto>> findAllByPatientDocumentPatientId(Long id);

   Result<PatientDocumentDto> saveUpload(PatientDocumentDto patientDocumentDto, MultipartFile file);
}

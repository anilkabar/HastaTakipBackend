package com.hastatakip.services;

import com.hastatakip.entites.dto.PatientExaminationDto;
import com.hastatakip.entites.model.PatientExamination;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IPatientExaminationService extends IBaseService<PatientExaminationDto> {

   Result<List<PatientExaminationDto>> getAllByPatientExaminationPatientId(Long id);
}

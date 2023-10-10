package com.hastatakip.services;

import com.hastatakip.entites.dto.PatientDto;
import com.hastatakip.entites.dto.PatientNoteDto;
import com.hastatakip.entites.model.PatientNote;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IPatientNoteService extends IBaseService<PatientNoteDto>{
    Result<List<PatientNoteDto>> findAllByPatientNotePatientId(Long id);

}

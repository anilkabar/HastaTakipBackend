package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.PatientExaminationDto;
import com.hastatakip.entites.mappers.impl.PatientExaminationMapperImpl;
import com.hastatakip.entites.model.PatientExamination;
import com.hastatakip.repositories.IPatientExaminationRepository;
import com.hastatakip.services.IPatientExaminationService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PatientExaminationServiceImpl implements IPatientExaminationService {

    @Autowired
    PatientExaminationMapperImpl patientExaminationMapper;

    @Autowired
    IPatientExaminationRepository patientExaminationRepository;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    @Override
    public Result<PatientExaminationDto> save(PatientExaminationDto patientExaminationDto) {

        if (patientExaminationDto==null){
            return new  Result<>(false,messageSourceAccessor.getMessage("result.NotNull"));
        }
        PatientExamination patientExamination=patientExaminationMapper.patientExaminationDtoToPatientExamination(patientExaminationDto);
        patientExamination.setDate(new Date());
        patientExaminationRepository.save(patientExamination);
        return new Result<>(true,messageSourceAccessor.getMessage("result.saveSuccess"));
    }

    @Override
    public Result<PatientExaminationDto> update(PatientExaminationDto patientExaminationDto) {
        return null;
    }

    @Override
    public Result<PatientExaminationDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<PatientExaminationDto>> getAll() {
        return null;
    }

    @Override
    public Result<PatientExaminationDto> deleteById(Long id) {
        patientExaminationRepository.deleteById(id);
        return new Result<>(true,messageSourceAccessor.getMessage("result.deleteSuccess"));
    }

    @Override
    public Result<List<PatientExaminationDto>> getAllByPatientExaminationPatientId(Long id) {
        List<PatientExamination> patientExaminationList=patientExaminationRepository.findAllByPatientId(id);
        List<PatientExaminationDto> patientExaminationDtoList=patientExaminationMapper.listPatientExaminationToPatientExaminationDto(patientExaminationList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientExaminationDtoList);
    }
}

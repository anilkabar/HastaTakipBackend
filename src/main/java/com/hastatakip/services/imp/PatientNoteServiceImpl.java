package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.PatientNoteDto;
import com.hastatakip.entites.mappers.impl.PatientNoteMapperImpl;
import com.hastatakip.entites.model.Patient;
import com.hastatakip.entites.model.PatientNote;
import com.hastatakip.repositories.IPatientNoteRepository;
import com.hastatakip.services.IPatientNoteService;
import com.hastatakip.utils.Result;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class PatientNoteServiceImpl implements IPatientNoteService {

    final PatientNoteMapperImpl patientNoteMapper;
    final IPatientNoteRepository patientNoteRepository;
    final MessageSourceAccessor messageSourceAccessor;

    public PatientNoteServiceImpl(PatientNoteMapperImpl patientNoteMapper, IPatientNoteRepository patientNoteRepository, MessageSourceAccessor messageSourceAccessor) {
        this.patientNoteMapper = patientNoteMapper;
        this.patientNoteRepository = patientNoteRepository;
        this.messageSourceAccessor = messageSourceAccessor;
    }


    @Override
    public Result<PatientNoteDto> save(PatientNoteDto patientNoteDto) {


        if (patientNoteDto.getContent()==""){
            return new Result<>(false,messageSourceAccessor.getMessage("NotNull"));
        }

        PatientNote patientNote=patientNoteMapper.patientNoteDtoTopatientNote(patientNoteDto);
        Date date=new Date();
        patientNote.setDate(date);
        patientNote=patientNoteRepository.save(patientNote);
        patientNoteDto=patientNoteMapper.patientnoteToPatientNoteDto(patientNote);
        return new Result<>(true,messageSourceAccessor.getMessage("result.saveSuccess"),patientNoteDto);
    }

    @Override
    public Result<PatientNoteDto> update(PatientNoteDto patientNoteDto) {
        return null;
    }

    @Override
    public Result<PatientNoteDto> getById(Long id) {
        Optional<PatientNote> optionalPatientNote=patientNoteRepository.findById(id);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientNoteMapper.patientnoteToPatientNoteDto(optionalPatientNote.get()));


    }

    @Override
    public Result<List<PatientNoteDto>> getAll() {

        List<PatientNote> patientNote=patientNoteRepository.findAll();
        List<PatientNoteDto> patientNoteDto=patientNoteMapper.listPatientNoteToPatientNoteDto(patientNote);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientNoteDto);
    }

    @Override
    public Result<PatientNoteDto> deleteById(Long id) {
        patientNoteRepository.deleteById(id);
        return  new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<List<PatientNoteDto>> findAllByPatientNotePatientId(Long id) {
        List<PatientNote> patientList=patientNoteRepository.findAllByPatientId(id);
        List<PatientNoteDto> patientNoteDtoList=patientNoteMapper.listPatientNoteToPatientNoteDto(patientList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientNoteDtoList);
    }
}

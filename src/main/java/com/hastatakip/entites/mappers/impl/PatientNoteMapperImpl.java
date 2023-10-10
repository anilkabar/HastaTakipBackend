package com.hastatakip.entites.mappers.impl;


import com.hastatakip.entites.dto.PatientNoteDto;
import com.hastatakip.entites.mappers.IPatientNoteDto;
import com.hastatakip.entites.model.Patient;
import com.hastatakip.entites.model.PatientNote;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PatientNoteMapperImpl implements IPatientNoteDto {

    final PatientMapperImpl patientMapper;

    public PatientNoteMapperImpl(PatientMapperImpl patientMapper) {
        this.patientMapper = patientMapper;
    }

    @Override
    public PatientNoteDto patientnoteToPatientNoteDto(PatientNote patientNote) {

        if (patientNote==null)
        {
            return null;
        }

        PatientNoteDto patientNoteDto=new PatientNoteDto();
        patientNoteDto.setId(patientNote.getId());
        patientNoteDto.setContent(patientNote.getContent());
        patientNoteDto.setDate(patientNote.getDate());
        patientNoteDto.setPatientDto(patientMapper.patientToPatientDto(patientNote.getPatient()));
        return patientNoteDto;
    }

    @Override
    public PatientNote patientNoteDtoTopatientNote(PatientNoteDto patientNoteDto) {

        PatientNote patientNote=new PatientNote();
        patientNote.setId(patientNoteDto.getId());
        patientNote.setContent(patientNoteDto.getContent());
        patientNote.setDate(patientNoteDto.getDate());
        patientNote.setPatient(patientMapper.patientDtoTopatient(patientNoteDto.getPatientDto()));
        return patientNote;
    }

    @Override
    public List<PatientNote> listPatientNoteDtoToPatientNote(List<PatientNoteDto> patientNoteDto) {
        List<PatientNote> patientNoteList=new ArrayList<>(patientNoteDto.size());
        patientNoteDto.forEach(item->{
            PatientNote patientNote=patientNoteDtoTopatientNote(item);
            patientNoteList.add(patientNote);
        });
        return patientNoteList;

    }

    @Override
    public List<PatientNoteDto> listPatientNoteToPatientNoteDto(List<PatientNote> patientNote) {
        List<PatientNoteDto> patientNoteDtoList=new ArrayList<>(patientNote.size());
        patientNote.forEach(item->{
            PatientNoteDto patientNoteDto=patientnoteToPatientNoteDto(item);
            patientNoteDtoList.add(patientNoteDto);
        });
        return patientNoteDtoList;
    }
}

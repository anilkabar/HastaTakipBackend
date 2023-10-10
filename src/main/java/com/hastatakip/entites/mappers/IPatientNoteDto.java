package com.hastatakip.entites.mappers;
import com.hastatakip.entites.dto.PatientNoteDto;
import com.hastatakip.entites.model.PatientNote;
import java.util.List;

public interface IPatientNoteDto {


    PatientNoteDto patientnoteToPatientNoteDto(PatientNote patientNote);
    PatientNote patientNoteDtoTopatientNote(PatientNoteDto patientNoteDto);

    List<PatientNote> listPatientNoteDtoToPatientNote(List<PatientNoteDto> patientNoteDto);
    List<PatientNoteDto> listPatientNoteToPatientNoteDto(List<PatientNote> patientNote);

}

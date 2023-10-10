package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.PatientDocumentDto;
import com.hastatakip.entites.model.PatientDocument;

import java.util.List;

public interface IPatientDocumentDto {

    PatientDocumentDto patientDocumentToPatientDocumentDto(PatientDocument patientDocument);
    PatientDocument patientDocumentDtoToPatientDocument(PatientDocumentDto patientDocumentDto);

    List<PatientDocument> listPatientDocumentDtoToPatientDocument(List<PatientDocumentDto> patientDocumentDtoList);
    List<PatientDocumentDto> listPatientDocumentToPatientDocumentDto(List<PatientDocument> patientDocumentList);
}

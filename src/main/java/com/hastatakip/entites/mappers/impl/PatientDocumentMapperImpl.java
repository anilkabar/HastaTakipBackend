package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.PatientDocumentDto;
import com.hastatakip.entites.mappers.IPatientDocumentDto;
import com.hastatakip.entites.model.PatientDocument;
import com.hastatakip.utils.FileProcess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

@Component
public class PatientDocumentMapperImpl implements IPatientDocumentDto {

    @Autowired
    PatientMapperImpl patientMapper;

    @Autowired
    ServletContext servletContext;

    @Override
    public PatientDocumentDto patientDocumentToPatientDocumentDto(PatientDocument patientDocument) {
        PatientDocumentDto patientDocumentDto=new PatientDocumentDto();
        patientDocumentDto.setId(patientDocument.getId());
        patientDocumentDto.setName(patientDocument.getName());
        patientDocumentDto.setPath(patientDocument.getPath());
        patientDocumentDto.setDate(patientDocument.getDate());
        patientDocumentDto.setPatientDto(patientMapper.patientToPatientDto(patientDocument.getPatient()));
        return patientDocumentDto;
    }

    @Override
    public PatientDocument patientDocumentDtoToPatientDocument(PatientDocumentDto patientDocumentDto) {
        PatientDocument patientDocument=new PatientDocument();
        patientDocument.setId(patientDocumentDto.getId());
        patientDocument.setName(patientDocumentDto.getName());
        patientDocument.setPath(patientDocumentDto.getPath());
        patientDocument.setDate(patientDocumentDto.getDate());
        patientDocument.setPatient(patientMapper.patientDtoTopatient(patientDocumentDto.getPatientDto()));
        return patientDocument;
    }

    @Override
    public List<PatientDocument> listPatientDocumentDtoToPatientDocument(List<PatientDocumentDto> patientDocumentDtoList) {

        List<PatientDocument> patientDocumentList=new ArrayList<>(patientDocumentDtoList.size());
        patientDocumentDtoList.forEach(item->{
            PatientDocument patientDocument=patientDocumentDtoToPatientDocument(item);
            patientDocumentList.add(patientDocument);
        });

        return patientDocumentList;
    }

    @Override
    public List<PatientDocumentDto> listPatientDocumentToPatientDocumentDto(List<PatientDocument> patientDocumentList) {
        FileProcess fileProcess=new FileProcess();
        String fileFolder="document";


        List<PatientDocumentDto> patientDocumentDtoList=new ArrayList<>(patientDocumentList.size());
        patientDocumentList.forEach(item->{
            String fileName=fileProcess.fileGet(item.getPath(),fileFolder,servletContext);
            item.setPath(fileName);
            PatientDocumentDto patientDocumentDto=patientDocumentToPatientDocumentDto(item);
            patientDocumentDtoList.add(patientDocumentDto);
        });

        return patientDocumentDtoList;
    }
}

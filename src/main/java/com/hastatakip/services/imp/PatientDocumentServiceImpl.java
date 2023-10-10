package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.PatientDocumentDto;
import com.hastatakip.entites.mappers.impl.PatientDocumentMapperImpl;
import com.hastatakip.entites.model.PatientDocument;
import com.hastatakip.repositories.IPatientDocumentRepository;
import com.hastatakip.services.IPatientDocumentService;
import com.hastatakip.utils.FileProcess;
import com.hastatakip.utils.Result;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;


@Service
public class PatientDocumentServiceImpl implements IPatientDocumentService {


    @Autowired
    ServletContext servletContext;

    @Autowired
    IPatientDocumentRepository documentRepository;

     @Autowired
    PatientDocumentMapperImpl patientDocumentMapper;

     @Autowired
    MessageSourceAccessor messageSourceAccessor;


    @Override
    public Result<PatientDocumentDto> save(PatientDocumentDto patientDocumentDto) {
        Date date=new Date();
        PatientDocument patientDocument=patientDocumentMapper.patientDocumentDtoToPatientDocument(patientDocumentDto);
        patientDocument.setDate(date);
        documentRepository.save(patientDocument);
        return new Result<>(true,messageSourceAccessor.getMessage("result.saveSuccess"));
    }

    @Override
    public Result<PatientDocumentDto> update(PatientDocumentDto patientDocumentDto) {
        return null;
    }

    @Override
    public Result<PatientDocumentDto> getById(Long id) {




        return null;
    }

    @Override
    public Result<List<PatientDocumentDto>> getAll() {
        List<PatientDocument> patientDocument=documentRepository.findAll();
        List<PatientDocumentDto> patientDocumentDtoList=patientDocumentMapper.listPatientDocumentToPatientDocumentDto(patientDocument);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientDocumentDtoList);
    }

    @Override
    public Result<PatientDocumentDto> deleteById(Long id) {
        Optional<PatientDocument> optional=documentRepository.findById(id);
        String path=optional.get().getPath();
        File file=new File("src/main/webapp/document/"+path);
        file.delete();
        documentRepository.deleteById(id);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<List<PatientDocumentDto>> findAllByPatientDocumentPatientId(Long id) {
        List<PatientDocument> patientDocumentList=documentRepository.findAllByPatientId(id);
        List<PatientDocumentDto> patientDocumentDtoList=patientDocumentMapper.listPatientDocumentToPatientDocumentDto(patientDocumentList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientDocumentDtoList);
    }

    @Override
    public Result<PatientDocumentDto> saveUpload(PatientDocumentDto patientDocumentDto, MultipartFile file) {
        Date date=new Date();
        Path uploadDirectory= Paths.get("src/main/webapp/document");
        PatientDocument patientDocument=patientDocumentMapper.patientDocumentDtoToPatientDocument(patientDocumentDto);
        patientDocument.setDate(date);
        System.out.println("Absolut"+uploadDirectory.toAbsolutePath());

        try {
            InputStream inputStream=file.getInputStream();
            String newPath=patientDocument.getPatient().getName()+
                    "_"+patientDocument.getPatient()
                    .getSurname()+"_"+patientDocument.getName()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
            Path filePath=uploadDirectory.resolve(newPath);
            Files.copy(inputStream,filePath,REPLACE_EXISTING);
            patientDocument.setPath(newPath);
            documentRepository.save(patientDocument);
        }
        catch (Exception e){
            System.out.println(e);
        }

        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }
}

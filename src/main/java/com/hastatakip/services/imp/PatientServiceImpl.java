package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.PatientDto;
import com.hastatakip.entites.mappers.impl.PatientMapperImpl;
import com.hastatakip.entites.model.Company;
import com.hastatakip.entites.model.Patient;
import com.hastatakip.entites.model.Users;
import com.hastatakip.repositories.ICompanyRepository;
import com.hastatakip.repositories.IPatientRepository;
import com.hastatakip.repositories.IUsersRepository;
import com.hastatakip.services.IPatientService;
import com.hastatakip.utils.FileProcess;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

@Service
public class PatientServiceImpl implements IPatientService {

    @Autowired
    ServletContext servletContext;

    final MessageSourceAccessor messageSourceAccessor;
    final IPatientRepository patientRepository;
    final PatientMapperImpl patientMapper;

    @Autowired
    IUsersRepository usersRepository;
    @Autowired
    ICompanyRepository companyRepository;

    public PatientServiceImpl(MessageSourceAccessor messageSourceAccessor, IPatientRepository patientRepository, PatientMapperImpl patientMapper) {
        this.messageSourceAccessor = messageSourceAccessor;
        this.patientRepository = patientRepository;
        this.patientMapper = patientMapper;
    }


    @Override
    public Result<PatientDto> save(PatientDto patientDto) {
        Patient patient=patientMapper.patientDtoTopatient(patientDto);
        patient=patientRepository.save(patient);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<PatientDto> update(PatientDto patientDto) {
        return null;
    }

    @Override
    public Result<PatientDto> getById(Long id){
        FileProcess fileProcess=new FileProcess();
        String fileFolder="images";
        Optional<Patient> optionalPatient=patientRepository.findById(id);
        String fileName=fileProcess.fileGet(optionalPatient.get().getImagePath(),fileFolder,servletContext);
        optionalPatient.get().setImagePath(fileName);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientMapper.patientToPatientDto(optionalPatient.get()));

    }

    @Override
    public Result<List<PatientDto>> getAll() {
        List<Patient> patientList=patientRepository.findAll();
        List<PatientDto> patientDtoList=patientMapper.listPatientToPatientDto(patientList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientDtoList);
    }


    @Override
    public Result<PatientDto> deleteById(Long id) {
        return null;
    }


    @Override
    public Result<PatientDto> saveUpload(PatientDto patientDto, MultipartFile file) {
        Optional<Company> optionalCompany=companyRepository.findById(patientDto.getCompany().getId());

        Path uploadDirectory=Paths.get("src/main/webapp/images");
        Patient patient=patientMapper.patientDtoTopatient(patientDto);
        if (optionalCompany.isPresent()){
            patient.setCompany(optionalCompany.get());
        }
        else{
            return new Result<>(false,messageSourceAccessor.getMessage("result.error"));
        }
        patient=patientRepository.save(patient);
        if(file!=null){
            try{
                InputStream inputStream=file.getInputStream();
                Path filePath=uploadDirectory.resolve(file.getOriginalFilename());
                Files.copy(inputStream,filePath,REPLACE_EXISTING);
            }
            catch (Exception e){
                System.out.println(e);

            }
        }

        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<List<PatientDto>> getAllById(String userName) {
        Optional<Users> optional=usersRepository.findByUsername(userName);
        if (optional.isPresent()){
            List<Patient> patientList=patientRepository.findAllByCompanyId(optional.get().getCompany().getId());
            List<PatientDto> patientDtoList=patientMapper.listPatientToPatientDto(patientList);
            return new Result<>(true,messageSourceAccessor.getMessage("result.success"),patientDtoList);
        }
        return new Result<>(false,messageSourceAccessor.getMessage("result.noData"));
    }

}

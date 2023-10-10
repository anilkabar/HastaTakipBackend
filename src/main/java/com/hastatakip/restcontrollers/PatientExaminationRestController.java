package com.hastatakip.restcontrollers;

import com.hastatakip.entites.dto.PatientExaminationDto;
import com.hastatakip.services.imp.PatientExaminationServiceImpl;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@CrossOrigin
@RestController
@RequestMapping("PatientExamination")
public class PatientExaminationRestController {
    @Autowired
    PatientExaminationServiceImpl patientExaminationService;


    @PostMapping("save")
    public ResponseEntity<Result> save(@RequestBody PatientExaminationDto patientExaminationDto){
        return ResponseEntity.ok(patientExaminationService.save(patientExaminationDto));
    }
    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Result> deleteById(@Positive(message = "Conver id")@PathVariable Long id){
        return ResponseEntity.ok(patientExaminationService.deleteById(id));
    }

    @GetMapping("getAllByPatientExaminationPatientId/{id}")
    public ResponseEntity<Result> getAllByPatientExaminationPatientId(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(patientExaminationService.getAllByPatientExaminationPatientId(id));
    }




}

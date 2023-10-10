package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.PatientDocumentDto;
import com.hastatakip.services.IPatientDocumentService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.io.IOException;

@RestController
@RequestMapping("PatientDocument")
@CrossOrigin
public class PatientDocumentController {

    @Autowired
    IPatientDocumentService patientDocumentService;

    @PostMapping("/save")
    public ResponseEntity<Result> save(@RequestPart(required = true) PatientDocumentDto patientDocumentDto, @RequestParam("file")MultipartFile file) throws IOException {

        return ResponseEntity.ok(patientDocumentService.saveUpload(patientDocumentDto,file));
    }

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(patientDocumentService.getAll());
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Result> deleteById(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(patientDocumentService.deleteById(id));
    }

    @GetMapping("getAllPatientDocumentPatientId/{id}")
    public ResponseEntity<Result> getById(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(patientDocumentService.findAllByPatientDocumentPatientId(id));
    }


}

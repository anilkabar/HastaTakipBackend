package com.hastatakip.restcontrollers;

import com.hastatakip.entites.dto.PatientNoteDto;
import com.hastatakip.services.IPatientNoteService;
import com.hastatakip.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;


@CrossOrigin
@RestController
@RequestMapping("/PatientNote")
public class PatientNoteController {

    final IPatientNoteService patientNoteService;

    public PatientNoteController(IPatientNoteService patientNoteService) {
        this.patientNoteService = patientNoteService;
    }
    @PostMapping("/save")
    public ResponseEntity<Result> saveNote(@RequestBody PatientNoteDto patientNoteDto){
        return ResponseEntity.ok(patientNoteService.save(patientNoteDto));
    }
    @GetMapping("/getAll")
    public ResponseEntity<Result> getAllNote(){
        return ResponseEntity.ok(patientNoteService.getAll());
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Result> deleteById(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(patientNoteService.deleteById(id));
    }

    //patient id si gelen id olan notların tamamını çekmek için kullanıldı
    @GetMapping("getAllPatientNotePatientId/{id}")
    public ResponseEntity<Result> getById(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(patientNoteService.findAllByPatientNotePatientId(id));
    }


}

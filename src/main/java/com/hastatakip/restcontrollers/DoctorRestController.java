package com.hastatakip.restcontrollers;

import com.hastatakip.entites.dto.DoctorDto;
import com.hastatakip.entites.model.Doctor;
import com.hastatakip.services.IDoctorService;
import com.hastatakip.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/Doctor")
@CrossOrigin
public class DoctorRestController {

    final IDoctorService service;

    public DoctorRestController(IDoctorService service) {
        this.service = service;
    }

    @PostMapping("DoctorAdd")
    public ResponseEntity<Result> save(@Valid @RequestParam DoctorDto doctorDto,Long id){

        return ResponseEntity.ok(service.save(doctorDto));
    }

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("getAllCompanyId/{id}")
    public ResponseEntity<Result> getAllCompanyId(@PathVariable Long id){
        return ResponseEntity.ok(service.getAllCompanyId(id));
    }
}

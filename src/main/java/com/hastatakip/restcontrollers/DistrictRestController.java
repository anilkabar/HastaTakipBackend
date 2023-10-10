package com.hastatakip.restcontrollers;


import com.hastatakip.services.imp.DistrictServiceImpl;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/District/")
public class DistrictRestController  {

    @Autowired
    private DistrictServiceImpl districtService;

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(districtService.getAll());
    }

    @GetMapping("findAllByCityId/{id}")
    public ResponseEntity<Result> findAllByCityId(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(districtService.findByAllCityId(id));
    }





}

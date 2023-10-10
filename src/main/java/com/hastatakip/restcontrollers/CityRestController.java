package com.hastatakip.restcontrollers;

import com.hastatakip.services.imp.CityServiceImpl;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/City")
public class CityRestController {

    @Autowired
    private CityServiceImpl cityService;


    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(cityService.getAll());
    }

}

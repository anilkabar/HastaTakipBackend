package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.StockPaymentDto;
import com.hastatakip.services.IStockPaymentService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/StockPayment")
@CrossOrigin
public class StockPaymentRestController {
    @Autowired
    IStockPaymentService stockPaymentService;

    @PostMapping("/save")
    public ResponseEntity<Result> save(@RequestBody StockPaymentDto stockPaymentDto){
        return ResponseEntity.ok(stockPaymentService.save(stockPaymentDto));
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Result> deleteById(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(stockPaymentService.deleteById(id));
    }

    @GetMapping("/findAllStockPaymentPatientId/{id}")
    public ResponseEntity<Result> findAllByPatientId(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(stockPaymentService.findAllByPatientId(id));
    }

    @GetMapping("/findAllPatientCompanyId/{id}")
    public ResponseEntity<Result> findAllPatientCompanyId(@PathVariable Long id){
        return ResponseEntity.ok(stockPaymentService.findAllByPatientCompanyId(id));
    }
}

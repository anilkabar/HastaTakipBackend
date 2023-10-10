package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.StockSaleDto;
import com.hastatakip.services.IStockSaleService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/StockSale")
@CrossOrigin
public class StockSaleRestController {

    @Autowired
    IStockSaleService stockSaleService;


    @PostMapping("save")
    public ResponseEntity<Result> save(@RequestBody StockSaleDto stockSaleDto){
        return ResponseEntity.ok(stockSaleService.save(stockSaleDto));
    }

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(stockSaleService.getAll());
    }

    @GetMapping("getAllByPatientId/{id}")
    public ResponseEntity<Result> getAllByPatientId(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(stockSaleService.getAllByPatientId(id));
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Result> deleteById(@Positive(message = "Conver id")@PathVariable Long id){
        return ResponseEntity.ok(stockSaleService.deleteById(id));
    }

    @GetMapping("findByPatientCompanyId/{id}")
    public ResponseEntity<Result> findByPatientCompanyId(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(stockSaleService.findByPatientCompanyId(id));
    }



}

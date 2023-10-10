package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.StockModelDto;
import com.hastatakip.services.IStockModelService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/StockModel")
@CrossOrigin
public class StockModelRestController {

    @Autowired
    private IStockModelService stockModelService;

    @PostMapping("save")
    public ResponseEntity<Result>save(@RequestBody StockModelDto stockModelDto){
        return ResponseEntity.ok(stockModelService.save(stockModelDto));
    }

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(stockModelService.getAll());
    }

    @DeleteMapping("deleteById/{id}")
    public ResponseEntity<Result> deleteById(@Positive(message = "Conver id") @PathVariable Long id){
        return ResponseEntity.ok(stockModelService.deleteById(id));
    }
}

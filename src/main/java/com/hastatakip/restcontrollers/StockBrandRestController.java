package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.StockBrandDto;
import com.hastatakip.services.IStockBrandService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/StockBrand")
@CrossOrigin
public class StockBrandRestController {

    @Autowired
    private IStockBrandService stockBrandService;

    @PostMapping("save")
    public ResponseEntity<Result> save(@RequestBody StockBrandDto stockBrandDto) throws IOException {
        return ResponseEntity.ok(stockBrandService.save(stockBrandDto));
    }

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(stockBrandService.getAll());
    }


    @GetMapping("stockBrandCompanyGetAll/{id}")
    public ResponseEntity<Result> stockBrandCompanyGetAll(@PathVariable Long id){

        return ResponseEntity.ok(stockBrandService.stockBrandCompanyGetAll(id));
    }

}

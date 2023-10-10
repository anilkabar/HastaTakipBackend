package com.hastatakip.restcontrollers;


import com.hastatakip.entites.dto.StockDto;
import com.hastatakip.entites.model.Stock;
import com.hastatakip.services.IStockService;
import com.hastatakip.services.imp.StockServiceImpl;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Stock")
@CrossOrigin
public class StockRestController {

    @Autowired
    IStockService stockService;


    @PostMapping("save")
    public ResponseEntity<Result> save(@RequestBody StockDto stockDto){
        return ResponseEntity.ok(stockService.save(stockDto));
    }

    @GetMapping("getAll")
    public ResponseEntity<Result> getAll(){
        return ResponseEntity.ok(stockService.getAll());
    }

    @GetMapping("stockGetAllCompanyId/{id}")
    public ResponseEntity<Result> stockGetAllCompanyId(@PathVariable Long id){
        return ResponseEntity.ok(stockService.stockGetAllCompanyId(id));
    }
    @GetMapping("deneme")
    public List<Stock> deneme(){
        return stockService.stockDeneme();
    }


}

package com.hastatakip.services.imp;


import com.hastatakip.entites.dto.StockDto;
import com.hastatakip.entites.mappers.impl.StockMapperImpl;
import com.hastatakip.entites.mappers.impl.StockModelMapperImpl;
import com.hastatakip.entites.model.Stock;
import com.hastatakip.repositories.IStockRepository;
import com.hastatakip.services.IStockService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockServiceImpl implements IStockService {

    @Autowired
    IStockRepository stockRepository;

    @Autowired
    StockMapperImpl stockMapper;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    @Override
    public Result<StockDto> save(StockDto stockDto) {
        Date date=new Date();
        Stock stock=stockMapper.stockDtoToStock(stockDto);
        stock.setDate(date);
        stockRepository.save(stock);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<StockDto> update(StockDto stockDto) {
        Optional<Stock> optionalStock=stockRepository.findById(stockDto.getId());
        if (optionalStock.isPresent()){
            Stock stock=stockMapper.stockDtoToStock(stockDto);
            stock=stockRepository.saveAndFlush(stock);
            return  new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockMapper.stockToStockDto(stock));
        }
        return null;
    }

    @Override
    public Result<StockDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<StockDto>> getAll() {
        List<Stock> stockList=stockRepository.findAll();
        List<StockDto> stockDtoList=stockMapper.listStockToStockDto(stockList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockDtoList);
    }

    @Override
    public Result<StockDto> deleteById(Long id) {
        return null;
    }


    @Override
    public Result<List<StockDto>> stockGetAllCompanyId(Long id) {
        List<Stock> stockList=stockRepository.findAllByCompanyId(id);
        List<StockDto> stockDtoList=stockMapper.listStockToStockDto(stockList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockDtoList);

    }

    @Override
    public List<Stock> stockDeneme() {

        return stockRepository.findAll();
    }


}

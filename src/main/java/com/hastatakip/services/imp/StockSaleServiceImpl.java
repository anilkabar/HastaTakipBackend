package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.StockSaleDto;
import com.hastatakip.entites.mappers.impl.StockMapperImpl;
import com.hastatakip.entites.mappers.impl.StockSaleMapperImpl;
import com.hastatakip.entites.model.Stock;
import com.hastatakip.entites.model.StockSale;
import com.hastatakip.repositories.IStockRepository;
import com.hastatakip.repositories.IStockSaleRepository;
import com.hastatakip.services.IStockSaleService;
import com.hastatakip.utils.GeneralTools;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockSaleServiceImpl implements IStockSaleService {

    @Autowired
    IStockSaleRepository stockSaleRepository;

    @Autowired
    IStockRepository stockRepository;

    @Autowired
    StockSaleMapperImpl stockSaleMapper;

    @Autowired
    StockServiceImpl stockService;

    @Autowired
    StockMapperImpl stockMapper;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;


    @Override
    public Result<StockSaleDto> save(StockSaleDto stockSaleDto) {
        StockSale stockSale=stockSaleMapper.stockSaleDtoToStockSale(stockSaleDto);
        stockSale=stockSaleRepository.save(stockSale);
        Optional<Stock> stock=stockRepository.findById(stockSaleDto.getStockDto().getId());
            Long sayi=stock.get().getStockAmount();
            stock.get().setStockAmount(sayi-1);
            stockService.update(stockMapper.stockToStockDto(stock.get()));

        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<StockSaleDto> update(StockSaleDto stockSaleDto) {
        return null;
    }

    @Override
    public Result<StockSaleDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<StockSaleDto>> getAll() {
        List<StockSale> stockSaleList=stockSaleRepository.findAll();
        List<StockSaleDto> stockSaleDtoList=stockSaleMapper.listStockSaleToStockSaleDto(stockSaleList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockSaleDtoList);
    }

    @Override
    public Result<StockSaleDto> deleteById(Long id) {
        Optional<StockSale> optional=stockSaleRepository.findById(id);
        Optional<Stock> stockOptional=stockRepository.findById(optional.get().getStock().getId());
        if (optional.isPresent()){
            stockSaleRepository.deleteById(id);
            Long sayi=stockOptional.get().getStockAmount();
            stockOptional.get().setStockAmount(sayi+1);
            stockService.update(stockMapper.stockToStockDto(stockOptional.get()));
            return new Result<>(true,messageSourceAccessor.getMessage("result.deleteSuccess"));
        }
        return new Result<>(false,messageSourceAccessor.getMessage("result.noData"));
    }

    @Override
    public Result<List<StockSaleDto>> getAllByPatientId(Long id) {
       List<StockSale> stockSaleList=stockSaleRepository.findAllByPatientId(id);
       List<StockSaleDto> stockSaleDtoList=stockSaleMapper.listStockSaleToStockSaleDto(stockSaleList);
       return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockSaleDtoList);
    }

    @Override
    public Result<List<StockSaleDto>> findByPatientCompanyId(Long id) {
        List<StockSale> stockSaleList=stockSaleRepository.findAllByPatientCompanyId(id);
        List<StockSaleDto> stockSaleDtoList=stockSaleMapper.listStockSaleToStockSaleDto(stockSaleList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockSaleDtoList);
    }
}

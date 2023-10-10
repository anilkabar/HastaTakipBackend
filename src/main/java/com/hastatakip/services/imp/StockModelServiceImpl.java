package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.StockModelDto;
import com.hastatakip.entites.mappers.impl.StockModelMapperImpl;
import com.hastatakip.entites.model.StockModel;
import com.hastatakip.repositories.IStockModelRepository;
import com.hastatakip.services.IStockModelService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockModelServiceImpl implements IStockModelService {

    @Autowired
    IStockModelRepository stockModelRepository;

    @Autowired
    StockModelMapperImpl stockModelMapper;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;


    @Override
    public Result<StockModelDto> save(StockModelDto stockModelDto) {
        if (stockModelDto!=null){
            Date date=new Date();
            StockModel stockModel=stockModelMapper.stockModelDtoToStockModel(stockModelDto);
            stockModel.setDate(date);
            stockModel=stockModelRepository.save(stockModel);
            return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
        }
        return null;
    }

    @Override
    public Result<StockModelDto> update(StockModelDto stockModelDto) {
        return null;
    }

    @Override
    public Result<StockModelDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<StockModelDto>> getAll() {
        List<StockModel> stockModelList=stockModelRepository.findAll();
        List<StockModelDto>stockModelDtoList=stockModelMapper.listStockModelToStockModelDto(stockModelList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockModelDtoList);
    }

    @Override
    public Result<StockModelDto> deleteById(Long id) {
        stockModelRepository.deleteById(id);
        return new Result<>(true,messageSourceAccessor.getMessage("result.deleteSuccess"));
    }
}

package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.StockBrandDto;
import com.hastatakip.entites.mappers.impl.StockBrandMapperImpl;
import com.hastatakip.entites.model.Company;
import com.hastatakip.entites.model.StockBrand;
import com.hastatakip.repositories.ICompanyRepository;
import com.hastatakip.repositories.IStockBrandRepository;
import com.hastatakip.services.IBaseService;
import com.hastatakip.services.IStockBrandService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class StockBrandServiceImpl implements IStockBrandService {

    @Autowired
    private IStockBrandRepository stockBrandRepository;

    @Autowired
    private StockBrandMapperImpl brandMapper;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @Autowired
    private ICompanyRepository companyRepository;

    @Override
    public Result<StockBrandDto> save(StockBrandDto stockBrandDto) {

        Date date=new Date();
        StockBrand stockBrand=brandMapper.stockBrandDtoToStockBrand(stockBrandDto);
        Optional<Company> companyopt=companyRepository.findById(stockBrandDto.getCompanyDto().getId());
        if (companyopt.isPresent()){
            stockBrand.setCompany(companyopt.get());
        }
        else
        {
            return new Result<>(false,messageSourceAccessor.getMessage("result.error"));
        }
        stockBrand.setDate(date);
        stockBrand=stockBrandRepository.save(stockBrand);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<StockBrandDto> update(StockBrandDto stockBrandDto) {
        return null;
    }

    @Override
    public Result<StockBrandDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<StockBrandDto>> getAll() {

        List<StockBrand> stockBrandList=stockBrandRepository.findAll();
        List<StockBrandDto> stockBrandDtoList=brandMapper.listStockBrandToStockBrandDto(stockBrandList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockBrandDtoList);
    }

    @Override
    public Result<StockBrandDto> deleteById(Long id) {
        return null;
    }


    @Override
    public Result<List<StockBrandDto>> stockBrandCompanyGetAll(Long id) {
        List<StockBrand> stockBrandList=stockBrandRepository.findAllByCompanyId(id);
        List<StockBrandDto> stockBrandDtoList=brandMapper.listStockBrandToStockBrandDto(stockBrandList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockBrandDtoList);
    }
}

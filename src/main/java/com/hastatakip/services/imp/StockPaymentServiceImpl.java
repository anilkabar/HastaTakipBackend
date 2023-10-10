package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.PatientDto;
import com.hastatakip.entites.dto.StockPaymentDto;
import com.hastatakip.entites.mappers.impl.StockPaymentMapperImpl;
import com.hastatakip.entites.model.Patient;
import com.hastatakip.entites.model.StockPayment;
import com.hastatakip.repositories.IPatientRepository;
import com.hastatakip.repositories.IStockPaymentRepository;
import com.hastatakip.services.IStockPaymentService;
import com.hastatakip.utils.Result;
import org.hibernate.cfg.beanvalidation.GroupsPerOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class StockPaymentServiceImpl implements IStockPaymentService {

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    @Autowired
    StockPaymentMapperImpl stockPaymentMapper;

    @Autowired
    IStockPaymentRepository stockPaymentRepository;

    @Autowired
    IPatientRepository patientRepository;

    @Override
    public Result<StockPaymentDto> save(StockPaymentDto stockPaymentDto) {

        if (stockPaymentDto==null){
            return new Result<>(false,messageSourceAccessor.getMessage("result.NotNull"));
        }
        StockPayment stockPayment=stockPaymentMapper.stockPaymentDtoToStockPayment(stockPaymentDto);
        stockPaymentRepository.save(stockPayment);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<StockPaymentDto> update(StockPaymentDto stockPaymentDto) {
        return null;
    }

    @Override
    public Result<StockPaymentDto> getById(Long id) {

        return null;
    }

    @Override
    public Result<List<StockPaymentDto>> getAll() {
        return null;
    }

    @Override
    public Result<StockPaymentDto> deleteById(Long id) {

        Optional<StockPayment> stockPaymentOptional=stockPaymentRepository.findById(id);
        if (stockPaymentOptional.isPresent()){
            stockPaymentRepository.deleteById(stockPaymentOptional.get().getId());
            return new Result<>(true,messageSourceAccessor.getMessage("result.deleteSuccess"));
        }

        return new Result<>(false,messageSourceAccessor.getMessage("result.noData"));
    }

    @Override
    public Result<List<StockPaymentDto>> findAllByPatientId(Long id) {
       //Optional<Patient> patientOptional=patientRepository.findById(id);

        List<StockPayment> stockPaymentList=stockPaymentRepository.findAllByPatientId(id);
        List<StockPaymentDto> stockPaymentDtoList=stockPaymentMapper.listStockPaymentToStockPaymentDto(stockPaymentList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockPaymentDtoList);
    }

    @Override
    public Result<List<StockPaymentDto>> findAllByPatientCompanyId(Long id) {
        List<StockPayment> stockPaymentList=stockPaymentRepository.findAllByPatientCompanyId(id);
        List<StockPaymentDto> stockPaymentDtoList=stockPaymentMapper.listStockPaymentToStockPaymentDto(stockPaymentList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),stockPaymentDtoList);
    }
}

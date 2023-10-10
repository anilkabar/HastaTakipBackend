package com.hastatakip.services.imp;

import com.hastatakip.entites.model.District;
import com.hastatakip.repositories.IDistrictRepository;
import com.hastatakip.services.IDistrictService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements IDistrictService<District> {

    @Autowired
    private IDistrictRepository districtRepository;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;



    public Result<List<District>> getAll(){
        List<District> districtList=districtRepository.findAll();
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),districtList);
    }

    @Override
    public Result<List<District>> findByAllCityId(Long id) {
        List<District> districtList=districtRepository.findAllByCityId(id);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),districtList);
    }

}

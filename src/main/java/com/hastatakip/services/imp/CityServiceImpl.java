package com.hastatakip.services.imp;

import com.hastatakip.entites.model.City;
import com.hastatakip.repositories.ICityRepository;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl {

    @Autowired
    private ICityRepository cityRepository;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    public Result<List<City>> getAll(){
        List<City> cityList=cityRepository.findAll();
        return new Result<>(true,"result.success",cityList);

    }
}

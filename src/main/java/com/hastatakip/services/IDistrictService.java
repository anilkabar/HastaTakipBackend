package com.hastatakip.services;

import com.hastatakip.utils.Result;

import java.util.List;

public interface IDistrictService<T> {
    Result<List<T>> getAll();

    Result<List<T>> findByAllCityId(Long id);

}

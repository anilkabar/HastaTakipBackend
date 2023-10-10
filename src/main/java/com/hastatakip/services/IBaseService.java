package com.hastatakip.services;
import com.hastatakip.entites.dto.IDto;
import com.hastatakip.utils.Result;
import java.util.List;


public interface IBaseService <T extends IDto> {

    Result<T> save(T t);
    Result<T> update(T t);
    Result<T> getById(Long id);
    Result<List<T>> getAll();
    Result<T> deleteById(Long id);

}

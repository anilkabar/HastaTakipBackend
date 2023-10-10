package com.hastatakip.services;

import com.hastatakip.entites.dto.UsersDto;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IUserService extends IBaseService<UsersDto>{

    Result<List<UsersDto>> userCompanyGetAll(Long id);

}

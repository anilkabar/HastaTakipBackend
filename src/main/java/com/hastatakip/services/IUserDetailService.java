package com.hastatakip.services;

import com.hastatakip.entites.dto.UserDetailDto;
import com.hastatakip.utils.Result;

import java.util.List;

public interface IUserDetailService extends IBaseService<UserDetailDto>{

    Result<List<UserDetailDto>> userGetAllCompanyId(Long id);

}

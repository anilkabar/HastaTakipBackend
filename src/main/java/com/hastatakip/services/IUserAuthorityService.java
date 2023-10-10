package com.hastatakip.services;

import com.hastatakip.entites.dto.UserAuthorityDto;
import com.hastatakip.utils.Result;

import java.util.LinkedHashMap;
import java.util.List;


public interface IUserAuthorityService extends IBaseService<UserAuthorityDto>{
    Result<List<UserAuthorityDto>> getAllByUserId(Long id);

    Result<List<UserAuthorityDto>> saveAndFlush(List<UserAuthorityDto> userAuthorityDtoList);




}

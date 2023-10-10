package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.UserAuthorityDto;
import com.hastatakip.entites.model.UserAuthority;

import java.util.List;

public interface IUserAuthorityDto {

    UserAuthorityDto userAuthorityToUserAuthorityDto(UserAuthority userAuthority);
    UserAuthority userAuthorityDtoToUserAuthority(UserAuthorityDto userAuthorityDto);
    List<UserAuthority> listUserAuthorityDtoToUserAuthority(List<UserAuthorityDto> userAuthorityDtoList);
    List<UserAuthorityDto> listUserAuthorityToUserAuthorityDto(List<UserAuthority> userAuthorityList);
}

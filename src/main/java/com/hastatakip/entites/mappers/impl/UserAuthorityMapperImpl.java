package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.UserAuthorityDto;
import com.hastatakip.entites.mappers.IUserAuthorityDto;
import com.hastatakip.entites.model.UserAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAuthorityMapperImpl implements IUserAuthorityDto {


    @Override
    public UserAuthorityDto userAuthorityToUserAuthorityDto(UserAuthority userAuthority) {

        if (userAuthority==null){
            return null;
        }
        UserAuthorityDto userAuthorityDto=new UserAuthorityDto();

        userAuthorityDto.setId(userAuthority.getId());
        userAuthorityDto.setPageAdminId(userAuthority.getPageAdmin().getId());
        return userAuthorityDto;
    }

    @Override
    public UserAuthority userAuthorityDtoToUserAuthority(UserAuthorityDto userAuthorityDto) {

        if (userAuthorityDto==null){
            return null;
        }
        UserAuthority userAuthority=new UserAuthority();
        userAuthority.setId(userAuthorityDto.getId());
        return userAuthority;
    }

    @Override
    public List<UserAuthority> listUserAuthorityDtoToUserAuthority(List<UserAuthorityDto> userAuthorityDtoList) {
        List<UserAuthority> userAuthorityList=new ArrayList<>(userAuthorityDtoList.size());
        userAuthorityDtoList.forEach(item->{
            UserAuthority userAuthority=userAuthorityDtoToUserAuthority(item);
            userAuthorityList.add(userAuthority);
        });
        return  userAuthorityList;
    }

    @Override
    public List<UserAuthorityDto> listUserAuthorityToUserAuthorityDto(List<UserAuthority> userAuthorityList) {
        List<UserAuthorityDto> userAuthorityDtoList=new ArrayList<>(userAuthorityList.size());
        userAuthorityList.forEach(item->{
            UserAuthorityDto userAuthorityDto=userAuthorityToUserAuthorityDto(item);
            userAuthorityDtoList.add(userAuthorityDto);
        });
        return userAuthorityDtoList;
    }
}

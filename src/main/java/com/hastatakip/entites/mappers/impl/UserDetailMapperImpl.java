package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.UserDetailDto;
import com.hastatakip.entites.mappers.IUserDetailDto;
import com.hastatakip.entites.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserDetailMapperImpl implements IUserDetailDto {
    @Override
    public UserDetailDto userDetailToUserDetailDto(Users user) {
        if (user==null){
            return null;
        }
        UserDetailDto userDetailDto=new UserDetailDto();
        userDetailDto.setId(user.getId());
        userDetailDto.setUsername(user.getUsername());
        userDetailDto.setNameandsurname(user.getNameandsurname());
        userDetailDto.setIsActive(user.getIsActive());
        return userDetailDto;
    }

    @Override
    public Users userDetailDtoToUserDetail(UserDetailDto userDetailDto) {
        if (userDetailDto==null){
            return null;
        }
        Users users=new Users();
        users.setId(userDetailDto.getId());
        users.setUsername(userDetailDto.getUsername());
        users.setNameandsurname(userDetailDto.getNameandsurname());
        users.setIsActive(userDetailDto.getIsActive());
        return users;
    }

    @Override
    public List<Users> userDetailDtoToUserDetail(List<UserDetailDto> usersDtoList) {
        List<Users> usersList=new ArrayList<>(usersDtoList.size());
        usersDtoList.forEach(item->{
            Users user=userDetailDtoToUserDetail(item);
            usersList.add(user);
        });
        return usersList;
    }

    @Override
    public List<UserDetailDto> userDetailToUserDetailDto(List<Users> usersList) {
        List<UserDetailDto> userDetailDtoList=new ArrayList<>(usersList.size());
        usersList.forEach(item->{
            UserDetailDto userDetailDto=userDetailToUserDetailDto(item);
            userDetailDtoList.add(userDetailDto);
        });
        return userDetailDtoList;
    }
}

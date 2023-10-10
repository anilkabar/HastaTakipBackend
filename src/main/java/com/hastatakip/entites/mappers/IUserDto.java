package com.hastatakip.entites.mappers;

import com.hastatakip.entites.dto.UsersDto;
import com.hastatakip.entites.model.Users;

import java.util.List;

public interface IUserDto {


    UsersDto usersToUsersDto(Users users);
    Users usersDtoToUsers(UsersDto usersDto);
    List<Users> listUsersDtoToUsers(List<UsersDto> usersDtoList);
    List<UsersDto> listUsersToUsersDto(List<Users> usersList);
}

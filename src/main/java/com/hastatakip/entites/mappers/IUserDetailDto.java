package com.hastatakip.entites.mappers;


import com.hastatakip.entites.dto.UserDetailDto;
import com.hastatakip.entites.dto.UsersDto;
import com.hastatakip.entites.model.Users;

import java.util.List;

public interface IUserDetailDto {

    UserDetailDto userDetailToUserDetailDto(Users user);
    Users userDetailDtoToUserDetail(UserDetailDto userDetailDto);
    List<Users> userDetailDtoToUserDetail(List<UserDetailDto> usersDtoList);
    List<UserDetailDto> userDetailToUserDetailDto(List<Users> usersList);

}

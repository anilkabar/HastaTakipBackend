package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.UsersDto;
import com.hastatakip.entites.mappers.IUserDto;
import com.hastatakip.entites.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UsersMapperImpl implements IUserDto {

    @Autowired
    CompanyMapperImpl companyMapper;


    @Override
    public UsersDto usersToUsersDto(Users users) {
        if (users==null){
            return null;
        }

        UsersDto usersDto=new UsersDto();
        usersDto.setId(users.getId());
        usersDto.setUsername(users.getUsername());
        usersDto.setPassword(users.getPassword());
        usersDto.setCompanyDto(companyMapper.companyToCompanyDto(users.getCompany()));
        return usersDto;
    }

    @Override
    public Users usersDtoToUsers(UsersDto usersDto) {
        if (usersDto==null){
            return null;
        }
        Users user=new Users();
        user.setId(usersDto.getId());
        user.setUsername(usersDto.getUsername());
        user.setPassword(usersDto.getPassword());
        user.setCompany(companyMapper.companyDtoToCompany(usersDto.getCompanyDto()));
        return user;
    }

    @Override
    public List<Users> listUsersDtoToUsers(List<UsersDto> usersDtoList) {
        List<Users> usersList =new ArrayList<>(usersDtoList.size());
        usersDtoList.forEach(item->{
            Users users=usersDtoToUsers(item);
            usersList.add(users);
        });

        return usersList;
    }

    @Override
    public List<UsersDto> listUsersToUsersDto(List<Users> usersList) {
        List<UsersDto> usersDtoList=new ArrayList<>(usersList.size());
        usersList.forEach(item->{
            UsersDto usersDto=usersToUsersDto(item);
            usersDtoList.add(usersDto);
        });

        return usersDtoList;
    }
}

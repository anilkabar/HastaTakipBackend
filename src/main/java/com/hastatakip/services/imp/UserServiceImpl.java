package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.UsersDto;
import com.hastatakip.entites.model.Users;
import com.hastatakip.services.IUserService;
import com.hastatakip.utils.Result;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Override
    public Result<UsersDto> save(UsersDto usersDto) {
        return null;
    }

    @Override
    public Result<UsersDto> update(UsersDto usersDto) {
        return null;
    }

    @Override
    public Result<UsersDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<UsersDto>> getAll() {
        return null;
    }

    @Override
    public Result<UsersDto> deleteById(Long id) {
        return null;
    }

    @Override
    public Result<List<UsersDto>> userCompanyGetAll(Long id) {
        //List<Users> users=
        return null;
    }
}

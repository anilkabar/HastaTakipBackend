package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.UserDetailDto;
import com.hastatakip.entites.mappers.impl.UserDetailMapperImpl;
import com.hastatakip.entites.model.Users;
import com.hastatakip.repositories.IUsersRepository;
import com.hastatakip.services.IUserDetailService;
import com.hastatakip.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements IUserDetailService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private UserDetailMapperImpl userDetailMapper;

    @Autowired
    private MessageSourceAccessor messageSourceAccessor;

    @Override
    public Result<UserDetailDto> save(UserDetailDto userDetailDto) {
        return null;
    }

    @Override
    public Result<UserDetailDto> update(UserDetailDto userDetailDto) {
        Optional<Users> usersOptional=usersRepository.findById(userDetailDto.getId());
        if (usersOptional.isPresent()){
            usersOptional.get().setIsActive(userDetailDto.getIsActive());
            usersRepository.saveAndFlush(usersOptional.get());
            return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
        }
        return null;
    }

    @Override
    public Result<UserDetailDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<UserDetailDto>> getAll() {
        return null;
    }

    @Override
    public Result<UserDetailDto> deleteById(Long id) {
        return null;
    }

    @Override
    public Result<List<UserDetailDto>> userGetAllCompanyId(Long id) {
        List<Users> users=usersRepository.findAllByCompanyId(id);
        List<UserDetailDto> userDetailDtoList=userDetailMapper.userDetailToUserDetailDto(users);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),userDetailDtoList);
    }
}

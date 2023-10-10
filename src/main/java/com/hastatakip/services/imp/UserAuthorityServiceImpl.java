package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.PageAdminDto;
import com.hastatakip.entites.dto.UserAuthorityDto;
import com.hastatakip.entites.mappers.impl.UserAuthorityMapperImpl;
import com.hastatakip.entites.model.PageAdmin;
import com.hastatakip.entites.model.UserAuthority;
import com.hastatakip.entites.model.Users;
import com.hastatakip.repositories.IPageAdminRepository;
import com.hastatakip.repositories.IUserAuthorityRepository;
import com.hastatakip.repositories.IUsersRepository;
import com.hastatakip.services.IUserAuthorityService;
import com.hastatakip.utils.Result;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAuthorityServiceImpl implements IUserAuthorityService {

    @Autowired
    IUserAuthorityRepository userAuthorityRepository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserAuthorityMapperImpl userAuthorityMapper;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    @Autowired
    IUsersRepository usersRepository;

    @Autowired
    IPageAdminRepository pageAdminRepository;

    @Override
    public Result<UserAuthorityDto> save(UserAuthorityDto userAuthorityDto) {
        Optional<Users> users=usersRepository.findById(userAuthorityDto.getUserId());
        Optional<PageAdmin> pageAdmin=pageAdminRepository.findById(userAuthorityDto.getPageAdminId());
        UserAuthority userAuthority=userAuthorityMapper.userAuthorityDtoToUserAuthority(userAuthorityDto);
        userAuthority.setUsers(users.get());
        userAuthority.setPageAdmin(pageAdmin.get());
        userAuthorityRepository.save(userAuthority);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }

    @Override
    public Result<UserAuthorityDto> update(UserAuthorityDto userAuthorityDto) {
        return null;
    }

    @Override
    public Result<UserAuthorityDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<UserAuthorityDto>> getAll() {
        return null;
    }

    @Override
    public Result<UserAuthorityDto> deleteById(Long id) {
        userAuthorityRepository.deleteById(id);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }


    @Override
    public Result<List<UserAuthorityDto>> getAllByUserId(Long id) {
        List<UserAuthority> userAuthorityList=userAuthorityRepository.findAllByUsersId(id);
        //List<UserAuthorityDto> userAuthorityDtoList=userAuthorityList.stream().map(userAuthority -> mapper.map(userAuthority,UserAuthorityDto.class)).collect(Collectors.toList());
        List<UserAuthorityDto> userAuthorityDtoList=userAuthorityMapper.listUserAuthorityToUserAuthorityDto(userAuthorityList);
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),userAuthorityDtoList);
    }

    @Override
    public Result<List<UserAuthorityDto>> saveAndFlush(List<UserAuthorityDto> userAuthorityDtoList) {
        userAuthorityDtoList.forEach(item->{
            Optional<UserAuthority> userAuthority= Optional.ofNullable(userAuthorityRepository.findByPageAdminIdAndUsersId(item.getPageAdminId(),item.getUserId()));
            if (userAuthority.isPresent()){
                if (item.getIsActive()==false){
                    deleteById(userAuthority.get().getId());
                }
            }
            else{
                save(item);
            }

        });

        return new Result<>(true,messageSourceAccessor.getMessage("result.success"));
    }


}

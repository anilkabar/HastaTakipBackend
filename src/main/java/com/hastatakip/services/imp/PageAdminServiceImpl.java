package com.hastatakip.services.imp;

import com.hastatakip.entites.dto.PageAdminDto;
import com.hastatakip.entites.model.PageAdmin;
import com.hastatakip.repositories.IPageAdminRepository;
import com.hastatakip.services.IPageAdminService;
import com.hastatakip.utils.Result;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PageAdminServiceImpl implements IPageAdminService {
    @Autowired(required = true)
    ModelMapper mapper;

    @Autowired
    IPageAdminRepository pageAdminRepository;

    @Autowired
    MessageSourceAccessor messageSourceAccessor;

    @Override
    public Result<PageAdminDto> save(PageAdminDto pageAdminDto) {

        return null;
    }

    @Override
    public Result<PageAdminDto> update(PageAdminDto pageAdminDto) {
        return null;
    }

    @Override
    public Result<PageAdminDto> getById(Long id) {
        return null;
    }

    @Override
    public Result<List<PageAdminDto>> getAll() {
        List<PageAdmin> pageAdminList=pageAdminRepository.findAll();
       // TypeToken<List<PageAdminDto>> typeToken = new TypeToken<>() {};
        List<PageAdminDto> pageAdminDtoList=pageAdminList.stream().map(pageAdmin -> mapper.map(pageAdmin,PageAdminDto.class)).collect(Collectors.toList());
        return new Result<>(true,messageSourceAccessor.getMessage("result.success"),pageAdminDtoList);
    }

    @Override
    public Result<PageAdminDto> deleteById(Long id) {
        return null;
    }
}

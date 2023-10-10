package com.hastatakip.entites.mappers.impl;

import com.hastatakip.entites.dto.CompanyDto;
import com.hastatakip.entites.mappers.ICompanyDto;
import com.hastatakip.entites.model.Company;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyMapperImpl implements ICompanyDto {
    @Override
    public CompanyDto companyToCompanyDto(Company company) {
        if (company==null){
            return null;
        }
        CompanyDto companyDto=new CompanyDto();
        companyDto.setId(company.getId());
        companyDto.setAddress(company.getAddress());
        companyDto.setPhone(company.getPhone());
        companyDto.setTaxAdministration(company.getTaxAdministration());
        companyDto.setTaxnumber(company.getTaxnumber());
        companyDto.setDistrict(company.getDistrict());
        return companyDto;
    }

    @Override
    public Company companyDtoToCompany(CompanyDto companyDto) {

        if (companyDto==null){
            return null;
        }

        Company company=new Company();
        company.setId(companyDto.getId());
        company.setAddress(companyDto.getAddress());
        company.setPhone(companyDto.getPhone());
        company.setTaxAdministration(companyDto.getTaxAdministration());
        company.setTaxnumber(companyDto.getTaxnumber());
        company.setDistrict(companyDto.getDistrict());
        return company;
    }

    @Override
    public List<Company> listCompanyDtoToCompany(List<CompanyDto> companyDto) {

        List<Company> companyList=new ArrayList<>(companyDto.size());
        companyDto.forEach(item->{
            Company company=companyDtoToCompany(item);
            companyList.add(company);
        });
        return companyList;
    }

    @Override
    public List<CompanyDto> listCompanyToCompanyDto(List<Company> companyList) {
        List<CompanyDto> companyDtoList=new ArrayList<>(companyList.size());
        companyList.forEach(item->{
            CompanyDto companyDto=companyToCompanyDto(item);
            companyDtoList.add(companyDto);
        });
        return companyDtoList;
    }
}

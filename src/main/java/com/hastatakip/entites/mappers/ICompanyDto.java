package com.hastatakip.entites.mappers;
import com.hastatakip.entites.dto.CompanyDto;
import com.hastatakip.entites.model.Company;
import java.util.List;


public interface ICompanyDto {

    CompanyDto companyToCompanyDto(Company company);
    Company companyDtoToCompany(CompanyDto companyDto);

    List<Company> listCompanyDtoToCompany(List<CompanyDto> companyDto);
    List<CompanyDto> listCompanyToCompanyDto(List<Company> companyList);
}

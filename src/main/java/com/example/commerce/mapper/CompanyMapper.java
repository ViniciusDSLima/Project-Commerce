package com.example.commerce.mapper;

import com.example.commerce.DTO.CompanyDTO;
import com.example.commerce.entity.Company;
import com.example.commerce.request.CompanyRegisterRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CompanyMapper {
    CompanyMapper INSTANCE = Mappers.getMapper(CompanyMapper.class);

    Company toCompany(CompanyRegisterRequest request);

    CompanyDTO toCompanyDTO(Company company);
}

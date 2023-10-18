package com.example.commerce.service;

import com.example.commerce.DTO.CompanyDTO;
import com.example.commerce.entity.Address;
import com.example.commerce.entity.Company;
import com.example.commerce.mapper.CompanyMapper;
import com.example.commerce.repository.AddressRepository;
import com.example.commerce.repository.CompanyRepository;
import com.example.commerce.request.CompanyRegisterRequest;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompanyService {

    private CompanyRepository companyRepository;
    
    private AddressRepository addressRepository;

    @Transactional
    public CompanyDTO registerCompany(@Valid CompanyRegisterRequest request){
        Company company = companyRepository.save(CompanyMapper.INSTANCE.toCompany(request));

        return CompanyMapper.INSTANCE.toCompanyDTO(company);
    }

    public CompanyDTO findByCityCompany(Long id,String city){

        List<Address> address = addressRepository.findByCity(city);

        if(address.isEmpty()){
            throw new  RuntimeException("address not found");
        }

        Company company = companyRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("company not found"));

        if(!company.getAddress().getCity().equals(address.get(0).getCity())){
            throw new RuntimeException();
        }

        return CompanyMapper.INSTANCE.toCompanyDTO(company);
    }

}

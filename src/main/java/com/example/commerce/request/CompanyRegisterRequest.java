package com.example.commerce.request;

import com.example.commerce.entity.Address;
import com.example.commerce.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CompanyRegisterRequest {

    private String name;

    private Category category;

    private Address address;
}

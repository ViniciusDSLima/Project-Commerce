package com.example.commerce.DTO;

import com.example.commerce.entity.Address;
import com.example.commerce.entity.Employee;
import com.example.commerce.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDTO {

    private String name;

    private Category category;

    private Address address;

    private List<Employee> employees;

}

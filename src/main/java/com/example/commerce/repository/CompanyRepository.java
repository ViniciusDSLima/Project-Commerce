package com.example.commerce.repository;

import com.example.commerce.entity.Address;
import com.example.commerce.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
}

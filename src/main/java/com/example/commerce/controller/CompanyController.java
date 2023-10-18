package com.example.commerce.controller;

import com.example.commerce.request.CompanyRegisterRequest;
import com.example.commerce.service.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/company")
@RestController
@AllArgsConstructor
public class CompanyController {

    private CompanyService companyService;


    @PostMapping("/register")
    public ResponseEntity companyRegister(@RequestBody @Valid CompanyRegisterRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.registerCompany(request));
    }

    @GetMapping("/{id}/{city}")
    public ResponseEntity findByCityCompany(@PathVariable Long id,@PathVariable String city){
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findByCityCompany(id,city));
    }
}

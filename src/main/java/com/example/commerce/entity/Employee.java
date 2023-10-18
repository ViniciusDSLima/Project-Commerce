package com.example.commerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String document;

    private String password;

    private BigDecimal salary;

    @ManyToOne
    @JoinColumn(name = "id_company")
    private Company company;

    @ManyToOne
    @JoinColumn(name = "id_address")
    private Address address;
}

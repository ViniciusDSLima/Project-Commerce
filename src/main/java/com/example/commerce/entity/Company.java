package com.example.commerce.entity;

import com.example.commerce.enums.Category;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "company")
    @Cascade(CascadeType.ALL)
    private List<Employee> employee;

    // O endereco nao precisa de uma empresa, ou seja, o mapeamento nao precisa/ nao pode ser bidirecional.
    @OneToOne(cascade = jakarta.persistence.CascadeType.PERSIST)
    @JoinColumn(name = "id_address")
    private Address address;
}

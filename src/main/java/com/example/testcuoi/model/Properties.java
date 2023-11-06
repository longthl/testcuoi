package com.example.testcuoi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Properties")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PropertyId")
    private int propertyId;
    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Products products;
    @Column(name = "PropertyName")
    private String propertyName;
    @Column(name = "PropertySort")
    private int propertySort;
}

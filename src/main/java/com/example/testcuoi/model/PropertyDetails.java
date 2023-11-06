package com.example.testcuoi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="PropertyDetails")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PropertyDetails {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PropertyDetailId")
    private int propertyDetailId;
@ManyToOne
    @JoinColumn(name="PropertyId")
    private Properties properties;
@Column(name="PropertyDetailCode")
    private String propertyDetailCode;
@Column(name="PropertyDetailDetail")
    private String propertyDetailDetail;
}

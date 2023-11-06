package com.example.testcuoi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ProductDetailPropertyDetails")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductDetailPropertyDetailId")
    private int productDetailPropertyDetailId;
    @ManyToOne
    @JoinColumn(name="ProductDetailId")
    private ProductDetails productDetails;
    @ManyToOne
    @JoinColumn(name="PropertyDetailId")
    private PropertyDetails propertyDetails;
    @ManyToOne
    @JoinColumn(name="ProductId")
    private Products products;

}

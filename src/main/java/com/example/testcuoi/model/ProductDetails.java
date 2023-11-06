package com.example.testcuoi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="ProductDetails")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProductDetailId")
    private int productDetailId;
    @Column(name="ProductPropertyName")
    private String productPropertyName;
    @Column(name="Quantity")
    private int quantity;
    @Column(name="Price")
    private double price;
    @Column(name="ShellPrice")
    private double shellPrice;
    @ManyToOne
    @JoinColumn(name="ParentId")
    private ProductDetails parentId;
}

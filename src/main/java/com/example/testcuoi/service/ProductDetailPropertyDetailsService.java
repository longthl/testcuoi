package com.example.testcuoi.service;

import com.example.testcuoi.model.ProductDetailPropertyDetails;
import com.example.testcuoi.model.Products;
import com.example.testcuoi.model.PropertyDetails;
import com.example.testcuoi.model.responobject.Respon;

import java.util.List;
import java.util.Optional;

public interface ProductDetailPropertyDetailsService {
    List<ProductDetailPropertyDetails> getAll();
    void insert(ProductDetailPropertyDetails productDetailPropertyDetails);
    Optional<ProductDetailPropertyDetails> getById(int productDetailPropertyDetailId);
    void delete(int productDetailPropertyDetailId);
   Respon<ProductDetailPropertyDetails>  mau(int productDetailPropertyDetailId, int m);
   Respon<ProductDetailPropertyDetails> capnhap(int productDetailPropertyDetailId,int sl);
//void updateQuantities(Products product, int quantityDifference);
}

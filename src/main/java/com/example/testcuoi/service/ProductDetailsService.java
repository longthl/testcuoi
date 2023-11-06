package com.example.testcuoi.service;

import com.example.testcuoi.model.ProductDetails;
import com.example.testcuoi.model.Products;
import com.example.testcuoi.model.responobject.Respon;

import java.util.List;
import java.util.Optional;

public interface ProductDetailsService {
    List<ProductDetails> getAll();
    void insert(ProductDetails productDetails);
    Optional<ProductDetails> getById(int productDetailId);
    void delete(int productDetailId);
    List<ProductDetails> getparent();
    Respon<ProductDetails> capnhat(int productDetailId,int sl);
}

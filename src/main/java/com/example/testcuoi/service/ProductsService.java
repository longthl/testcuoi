package com.example.testcuoi.service;

import com.example.testcuoi.model.Products;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<Products>getAll();
    void insert(Products products);
    Products getById(int productId);
    void delete(int productId);
}

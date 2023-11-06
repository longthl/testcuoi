package com.example.testcuoi.service.Impl;

import com.example.testcuoi.model.Products;
import com.example.testcuoi.repository.ProductsRepository;
import com.example.testcuoi.service.ProductsService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Products> getAll() {
        return productsRepository.findAll();
    }

    @Override
    public void insert(Products products) {
     productsRepository.save(products);
    }

    @Override
    public Products getById(int productId) {
        return productsRepository.findByProductId(productId);
    }

    @Override
    public void delete(int productId) {

    }
}

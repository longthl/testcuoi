package com.example.testcuoi.service;

import com.example.testcuoi.model.Products;
import com.example.testcuoi.model.Properties;

import java.util.List;
import java.util.Optional;

public interface PropertiesService {
    List<Properties> getAll();
    void insert(Properties properties);
    Optional<Properties> getById(int propertiesId);
    void delete(int propertiesId);
}

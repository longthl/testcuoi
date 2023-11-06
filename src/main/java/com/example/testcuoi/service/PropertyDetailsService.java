package com.example.testcuoi.service;

import com.example.testcuoi.model.Properties;
import com.example.testcuoi.model.PropertyDetails;

import java.util.List;
import java.util.Optional;

public interface PropertyDetailsService {
    List<PropertyDetails> getAll();
    void insert(PropertyDetails propertyDetails);
    Optional<PropertyDetails> getById(int propertyDetailId);
    void delete(int propertyDetailId);
}

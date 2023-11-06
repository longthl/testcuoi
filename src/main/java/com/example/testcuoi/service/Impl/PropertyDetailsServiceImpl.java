package com.example.testcuoi.service.Impl;

import com.example.testcuoi.model.PropertyDetails;
import com.example.testcuoi.repository.PropertyDetailsRepository;
import com.example.testcuoi.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertyDetailsServiceImpl implements PropertyDetailsService {
@Autowired
    PropertyDetailsRepository propertyDetailsRepository;

    @Override
    public List<PropertyDetails> getAll() {
        return propertyDetailsRepository.findAll();
    }

    @Override
    public void insert(PropertyDetails propertyDetails) {
     propertyDetailsRepository.save(propertyDetails);
    }

    @Override
    public Optional<PropertyDetails> getById(int propertyDetailId) {
        return propertyDetailsRepository.findById(propertyDetailId);
    }

    @Override
    public void delete(int propertyDetailId) {

    }
}

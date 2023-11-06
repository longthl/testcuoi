package com.example.testcuoi.service.Impl;

import com.example.testcuoi.model.Properties;
import com.example.testcuoi.repository.PropertiesRepository;
import com.example.testcuoi.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PropertiesServiceImpl implements PropertiesService {
    @Autowired
    PropertiesRepository propertiesRepository;

    @Override
    public List<Properties> getAll() {
        return propertiesRepository.findAll();
    }

    @Override
    public void insert(Properties properties) {
     propertiesRepository.save(properties);
    }

    @Override
    public Optional<Properties> getById(int propertiesId) {
        return propertiesRepository.findById(propertiesId);
    }

    @Override
    public void delete(int propertiesId) {

    }
}

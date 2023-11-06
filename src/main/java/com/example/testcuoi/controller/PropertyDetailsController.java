package com.example.testcuoi.controller;

import com.example.testcuoi.model.PropertyDetails;
import com.example.testcuoi.repository.PropertyDetailsRepository;
import com.example.testcuoi.service.ProductDetailsService;
import com.example.testcuoi.service.PropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property-details")
public class PropertyDetailsController {
    @Autowired
    PropertyDetailsService propertyDetailsService;
    @GetMapping("/hien-thi")
    public List<PropertyDetails> getAll(){
        List<PropertyDetails>list=propertyDetailsService.getAll();
        return list;
    }
}

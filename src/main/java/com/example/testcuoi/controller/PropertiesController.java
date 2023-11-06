package com.example.testcuoi.controller;

import com.example.testcuoi.model.Properties;
import com.example.testcuoi.service.PropertiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/properties")
public class PropertiesController {
    @Autowired
    PropertiesService propertiesService;
    @GetMapping("/hien-thi")
    public List<Properties> getAll(){
        List<Properties>list=propertiesService.getAll();
        return list;
    }
}

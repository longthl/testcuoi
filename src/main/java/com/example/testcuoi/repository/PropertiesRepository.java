package com.example.testcuoi.repository;

import com.example.testcuoi.model.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertiesRepository extends JpaRepository<Properties,Integer> {
}

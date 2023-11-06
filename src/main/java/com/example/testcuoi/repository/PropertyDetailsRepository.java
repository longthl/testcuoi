package com.example.testcuoi.repository;

import com.example.testcuoi.model.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropertyDetailsRepository extends JpaRepository<PropertyDetails,Integer> {
}

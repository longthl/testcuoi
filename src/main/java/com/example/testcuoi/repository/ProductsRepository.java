package com.example.testcuoi.repository;

import com.example.testcuoi.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsRepository extends JpaRepository<Products,Integer> {
Products findByProductId(int product);
}

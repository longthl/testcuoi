package com.example.testcuoi.repository;

import com.example.testcuoi.model.ProductDetailPropertyDetails;
import com.example.testcuoi.model.ProductDetails;
import com.example.testcuoi.model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDetailPropertyDetailsRepository extends JpaRepository<ProductDetailPropertyDetails,Integer> {
//@Query("select pdpd from ProductDetailPropertyDetails pdpd where pdpd.productDetails.quantity =:quantity")
    List<ProductDetailPropertyDetails> findByProductDetails(ProductDetails product);
    @Modifying
    @Query("UPDATE ProductDetails pd " +
            "SET pd.quantity = pd.quantity + :quantityDifference " +
            "WHERE pd IN (SELECT pdpd.productDetails FROM ProductDetailPropertyDetails pdpd WHERE pdpd.productDetails = :product)")
    void updateProductAndPropertyQuantities(@Param("product") ProductDetails product, @Param("quantityDifference") int quantityDifference);
    List<ProductDetailPropertyDetails> findByProducts(Products products);
}

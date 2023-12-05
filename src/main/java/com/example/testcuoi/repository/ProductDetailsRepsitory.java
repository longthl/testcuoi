package com.example.testcuoi.repository;

import com.example.testcuoi.model.ProductDetails;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductDetailsRepsitory extends JpaRepository<ProductDetails,Integer> {
    @Transactional
    @Modifying
@Query(value = "SELECT pd.* FROM ProductDetails pd LEFT JOIN ProductDetails pd2 ON pd.productDetailId = pd2.parentId  WHERE pd2.parentId IS NULL",nativeQuery = true)
    List<ProductDetails> findAllProductsWithLastProperty();

   List<ProductDetails> getAllByParentId(ProductDetails parentId);

   ProductDetails findByProductPropertyName(String name);
//@Query("UPDATE ProductDetails pd set pd.quantity =: quantity where pd.parentId =: parentId")
//    void update(@Param("quantity")int quantity,@Param("parentId")int parentId);
}

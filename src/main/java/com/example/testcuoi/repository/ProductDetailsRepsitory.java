package com.example.testcuoi.repository;

import com.example.testcuoi.model.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface ProductDetailsRepsitory extends JpaRepository<ProductDetails,Integer> {
@Query("select p from ProductDetails p where p.productPropertyName =(select max(pp.productPropertyName) from ProductDetails pp where pp.parentId =p.parentId)")
    List<ProductDetails> findAllProductsWithLastProperty();
   List<ProductDetails> getAllByParentId(ProductDetails parentId);
//@Query("UPDATE ProductDetails pd set pd.quantity =: quantity where pd.parentId =: parentId")
//    void update(@Param("quantity")int quantity,@Param("parentId")int parentId);
}

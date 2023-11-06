package com.example.testcuoi.controller;

import com.example.testcuoi.model.Products;
import com.example.testcuoi.service.ProductDetailPropertyDetailsService;
import com.example.testcuoi.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {
@Autowired
    ProductsService productsService;
    @Autowired
    private ProductDetailPropertyDetailsService productDetailPropertyDetailsService;

@GetMapping("/hien-thi")
public List<Products> getAll(){
    List<Products>list=productsService.getAll();
    return list;
}
//    @PutMapping("/update-quantities/{productId}/{quantityDifference}")
//    public ResponseEntity<String> updateProductQuantities(@PathVariable("productId") int productId, @PathVariable("quantityDifference") int quantityDifference) {
//        // Kiểm tra xem sản phẩm có tồn tại không
//        Products product = productsService.getById(productId);
//        if (product == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Sản phẩm không tồn tại");
//        }
//
//        // Cập nhật số lượng sản phẩm và các đời thuộc tính
//        productDetailPropertyDetailsService.updateQuantities(product,quantityDifference);
//        return ResponseEntity.ok("Cập nhật số lượng thành công");
//    }
}

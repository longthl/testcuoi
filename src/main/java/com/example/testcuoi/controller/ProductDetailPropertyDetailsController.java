package com.example.testcuoi.controller;

import com.example.testcuoi.model.ProductDetailPropertyDetails;
import com.example.testcuoi.model.responobject.Respon;
import com.example.testcuoi.service.ProductDetailPropertyDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productdetail-propertydetails")
public class ProductDetailPropertyDetailsController {
    @Autowired
    ProductDetailPropertyDetailsService productDetailPropertyDetailsService;
    @GetMapping("/hien-thi")
    public List<ProductDetailPropertyDetails> getAll(){
        List<ProductDetailPropertyDetails> list=productDetailPropertyDetailsService.getAll();
        return list;
    }
    @PostMapping("/muasanpham/{productDetailPropertyDetailId}/{mua}")
    public Respon<ProductDetailPropertyDetails> mua(@PathVariable("productDetailPropertyDetailId")Integer id, @PathVariable("mua")Integer mua){
        return productDetailPropertyDetailsService.mau(id,mua);

    }
    @PostMapping("/capnhat/{id}/{sl}")
    public Respon<ProductDetailPropertyDetails>capnhat(@PathVariable("id")Integer id,@PathVariable("sl") Integer sl){
        return productDetailPropertyDetailsService.capnhap(id,sl);
    }

}

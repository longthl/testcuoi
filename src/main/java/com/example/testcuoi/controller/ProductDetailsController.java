package com.example.testcuoi.controller;

import com.example.testcuoi.model.ProductDetailPropertyDetails;
import com.example.testcuoi.model.ProductDetails;
import com.example.testcuoi.model.responobject.Respon;
import com.example.testcuoi.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-Details")
public class ProductDetailsController {
    @Autowired
    ProductDetailsService productDetailsService;
    @GetMapping("/hienthi")
    public List<ProductDetails> getAll(){
       List<ProductDetails> list= productDetailsService.getAll();
    return list;
    }
    @GetMapping("/getall")
    public List<ProductDetails>hienthi(){
        List<ProductDetails>list=productDetailsService.getparent();
        return list;
    }
    @PostMapping("/them")
    public String insert(@RequestBody ProductDetails productDetails){
        productDetailsService.insert(productDetails);
        return "thành công";
    }
    @PostMapping("/capnhat/{id}/{sl}")
    public Respon<ProductDetails> capnhat(@PathVariable("id")Integer id, @PathVariable("sl") Integer sl){
        return productDetailsService.capnhat(id,sl);
    }
}

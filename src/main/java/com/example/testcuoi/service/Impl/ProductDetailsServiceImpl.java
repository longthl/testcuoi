package com.example.testcuoi.service.Impl;

import com.example.testcuoi.model.ProductDetailPropertyDetails;
import com.example.testcuoi.model.ProductDetails;
import com.example.testcuoi.model.responobject.Respon;
import com.example.testcuoi.repository.ProductDetailsRepsitory;
import com.example.testcuoi.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class  ProductDetailsServiceImpl implements ProductDetailsService {
    @Autowired
    ProductDetailsRepsitory productDetailsRepsitory;

    @Override
    public List<ProductDetails> getAll() {
        return productDetailsRepsitory.findAll();
    }

    @Override
    public void insert(ProductDetails productDetails) {
        productDetailsRepsitory.save(productDetails);
    }

    @Override
    public Optional<ProductDetails> getById(int productDetailId) {
        return Optional.empty();
    }

    @Override
    public void delete(int productDetailId) {

    }

    @Override
    public List<ProductDetails> getparent() {
        return productDetailsRepsitory.findAllProductsWithLastProperty();
    }

    @Override
    public Respon<ProductDetails> capnhat(String productPropertyName, int sl) {
        ProductDetails pd = productDetailsRepsitory.findByProductPropertyName(productPropertyName);
        Respon<ProductDetails> repon = new Respon<>();
        if (pd != null) {
            if (sl >= 1) {
                int soluonghientai = pd.getQuantity();
                System.out.println(soluonghientai);
                int cn = soluonghientai + sl;
                System.out.println(cn);
                pd.setQuantity(cn);
                while (pd.getParentId() != null) {
                    pd = pd.getParentId();
                    pd.setQuantity(pd.getQuantity() + sl);
                }
                productDetailsRepsitory.save(pd);
                repon.setError("Cập nhập số lượng thành công");
            } else {
                repon.setError("số lượng cập nhập phải lớn hơn 0");
            }
        } else {
            repon.setError("ProductDetails không có");
        }
        return repon;
    }

    @Override
    public Respon<ProductDetails> demo(String productPropertyName, int sl) {
        ProductDetails pd = productDetailsRepsitory.findByProductPropertyName(productPropertyName);
        Respon<ProductDetails> respon = new Respon<>();
        if (pd != null) {
            if (sl >= 1) {
                int soluonghientai = pd.getQuantity();
                System.out.println(soluonghientai);
                int cn = soluonghientai - sl;
                if (cn >= 0) {
                    System.out.println(cn);
                    pd.setQuantity(cn);
                    while (pd.getParentId() != null) {
                        pd = pd.getParentId();
                        pd.setQuantity(pd.getQuantity() - sl);
                    }
                    productDetailsRepsitory.save(pd);
                    respon.setError("Mua thành công");
                } else {
                    respon.setError("Sản phẩm không đủ");
                }
            } else {
                respon.setError("số lượng cập nhập phải lớn hơn 0");
            }
        } else {
            respon.setError("ProductDetails không có");
        }

        return respon;
    }
}

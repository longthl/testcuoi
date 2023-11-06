package com.example.testcuoi.service.Impl;

import com.example.testcuoi.model.ProductDetailPropertyDetails;
import com.example.testcuoi.model.ProductDetails;
import com.example.testcuoi.model.Products;
import com.example.testcuoi.model.responobject.Respon;
import com.example.testcuoi.repository.ProductDetailPropertyDetailsRepository;
import com.example.testcuoi.repository.ProductDetailsRepsitory;
import com.example.testcuoi.service.ProductDetailPropertyDetailsService;
import com.example.testcuoi.service.ProductDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductDetailPropertyDetailsServiceImpl implements ProductDetailPropertyDetailsService {
    @Autowired
    ProductDetailPropertyDetailsRepository productDetailPropertyDetailsRepository;
    @Autowired
    ProductDetailsRepsitory productDetailsRepsitory;
    @Autowired
    ProductDetailsService productDetailsService;

    @Override
    public List<ProductDetailPropertyDetails> getAll() {
        return productDetailPropertyDetailsRepository.findAll();
    }

    @Override
    public void insert(ProductDetailPropertyDetails productDetailPropertyDetails) {
        productDetailPropertyDetailsRepository.save(productDetailPropertyDetails);
    }

    @Override
    public Optional<ProductDetailPropertyDetails> getById(int productDetailPropertyDetailId) {

        return Optional.empty();
    }

    @Override
    public void delete(int productDetailPropertyDetailId) {

    }

    @Override
    public Respon<ProductDetailPropertyDetails> mau(int productDetailPropertyDetailId, int m) {
        ProductDetailPropertyDetails pd = productDetailPropertyDetailsRepository.findById(productDetailPropertyDetailId).orElse(null);
        Respon<ProductDetailPropertyDetails> repon=new Respon<>();
        if(pd !=null) {
            int pr = pd.getProductDetails().getQuantity();
            int prd = pd.getProductDetails().getProductDetailId();
            ProductDetails pro = productDetailsRepsitory.findById(prd).orElse(null);
            System.out.println(pro.getParentId());
            if (pr >= 1) {
                if(m >=1) {
                    int kq = pr - m;
                    if (kq >= 0) {
                        pro.setQuantity(kq);
                        while (pro.getParentId() !=null){
                            pro=pro.getParentId();
                            pro.setQuantity(pro.getQuantity() - m);
                        }
                        productDetailsRepsitory.save(pro);
                        repon.setError("Mua hàng thành công");
                    } else {
                        repon.setError("Không đủ sản phẩm");
                    }
                }else {
                    repon.setError("số lượng mua phải lớn hơn 0");
                }
            } else {
                repon.setError("Sản phâm mua phải lớn hơn 0");
            }
        }else {
            repon.setError("Chi tiet thuộc tính và sản phẩm không tồn tại");
        }
        return repon;
}

    @Override
    public Respon<ProductDetailPropertyDetails> capnhap(int productDetailPropertyDetailId, int sl) {
        ProductDetailPropertyDetails pr=productDetailPropertyDetailsRepository.findById(productDetailPropertyDetailId).orElse(null);
        Respon<ProductDetailPropertyDetails> repon=new Respon<>();
        if(pr != null){
            int pd=pr.getProductDetails().getQuantity();
            int prd=pr.getProductDetails().getProductDetailId();
            ProductDetails pro = productDetailsRepsitory.findById(prd).orElse(null);
            if(sl>=1) {
                int kq = pd + sl;
                pr.getProductDetails().setQuantity(kq);
                productDetailPropertyDetailsRepository.save(pr);
                List<ProductDetailPropertyDetails> propertyDetailsList=productDetailPropertyDetailsRepository.findByProductDetails(pr.getProductDetails());
                for(ProductDetailPropertyDetails ct:propertyDetailsList){
                    int propertyQuantity=ct.getProductDetails().getQuantity();
                    ct.getProductDetails().setQuantity(propertyQuantity+sl);
                    productDetailPropertyDetailsRepository.save(ct);
                }
                repon.setError("Cập nhật số lượng thành công");
            }else {
                repon.setError("số lượng cập nhật phải lớn hơn 0");
            }
        }else {
            repon.setError("Chi tiet thuộc tính và sản phẩm không tồn tại");
        }
        return repon;
    }
}

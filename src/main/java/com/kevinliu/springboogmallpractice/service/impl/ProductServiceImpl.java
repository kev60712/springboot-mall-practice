package com.kevinliu.springboogmallpractice.service.impl;

import com.kevinliu.springboogmallpractice.constant.ProductCategory;
import com.kevinliu.springboogmallpractice.dto.ProductRequest;
import com.kevinliu.springboogmallpractice.model.Product;
import com.kevinliu.springboogmallpractice.repo.ProductRepo;
import com.kevinliu.springboogmallpractice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getProducts(ProductCategory category, String search) {
        return productRepo.getProducts(category, search);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productRepo.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productRepo.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productRepo.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productRepo.deleteProductById(productId);
    }
}

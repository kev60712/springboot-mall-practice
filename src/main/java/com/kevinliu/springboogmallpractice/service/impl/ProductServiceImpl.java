package com.kevinliu.springboogmallpractice.service.impl;

import com.kevinliu.springboogmallpractice.dto.ProductQueryParams;
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
    public Integer countProduct(ProductQueryParams productQueryParams) {
        return productRepo.countProduct(productQueryParams);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        return productRepo.getProducts(productQueryParams);
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

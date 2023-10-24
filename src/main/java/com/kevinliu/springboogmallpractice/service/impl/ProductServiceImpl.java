package com.kevinliu.springboogmallpractice.service.impl;

import com.kevinliu.springboogmallpractice.model.Product;
import com.kevinliu.springboogmallpractice.repo.ProductRepo;
import com.kevinliu.springboogmallpractice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product getProductById(Integer productId) {
        return productRepo.getProductById(productId);
    }
}

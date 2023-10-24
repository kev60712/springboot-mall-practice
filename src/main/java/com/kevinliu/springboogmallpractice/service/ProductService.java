package com.kevinliu.springboogmallpractice.service;

import com.kevinliu.springboogmallpractice.dto.ProductRequest;
import com.kevinliu.springboogmallpractice.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}

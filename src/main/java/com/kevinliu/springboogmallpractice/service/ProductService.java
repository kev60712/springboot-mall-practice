package com.kevinliu.springboogmallpractice.service;

import com.kevinliu.springboogmallpractice.dto.ProductQueryParams;
import com.kevinliu.springboogmallpractice.dto.ProductRequest;
import com.kevinliu.springboogmallpractice.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParams productQueryParams);

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}

package com.kevinliu.springboogmallpractice.repo;

import com.kevinliu.springboogmallpractice.constant.ProductCategory;
import com.kevinliu.springboogmallpractice.dto.ProductRequest;
import com.kevinliu.springboogmallpractice.model.Product;

import java.util.List;

public interface ProductRepo {

    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}

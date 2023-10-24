package com.kevinliu.springboogmallpractice.repo;

import com.kevinliu.springboogmallpractice.dto.ProductRequest;
import com.kevinliu.springboogmallpractice.model.Product;

public interface ProductRepo {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}

package com.kevinliu.springboogmallpractice.repo;

import com.kevinliu.springboogmallpractice.model.Product;

public interface ProductRepo {

    Product getProductById(Integer productId);

}
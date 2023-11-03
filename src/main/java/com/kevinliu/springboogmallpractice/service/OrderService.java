package com.kevinliu.springboogmallpractice.service;

import com.kevinliu.springboogmallpractice.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}

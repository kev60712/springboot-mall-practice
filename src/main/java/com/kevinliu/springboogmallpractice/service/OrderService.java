package com.kevinliu.springboogmallpractice.service;

import com.kevinliu.springboogmallpractice.dto.CreateOrderRequest;
import com.kevinliu.springboogmallpractice.model.Order;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

}

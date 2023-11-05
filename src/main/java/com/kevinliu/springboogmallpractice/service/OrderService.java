package com.kevinliu.springboogmallpractice.service;

import com.kevinliu.springboogmallpractice.dto.CreateOrderRequest;
import com.kevinliu.springboogmallpractice.dto.OrderQueryParams;
import com.kevinliu.springboogmallpractice.model.Order;

import java.util.List;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);
}

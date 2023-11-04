package com.kevinliu.springboogmallpractice.repo;

import com.kevinliu.springboogmallpractice.model.Order;
import com.kevinliu.springboogmallpractice.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItem(Integer orderId, List<OrderItem> orderItemList);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemsByOrderId(Integer orderId);

}
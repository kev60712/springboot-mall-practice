package com.kevinliu.springboogmallpractice.service.impl;

import com.kevinliu.springboogmallpractice.dto.BuyItem;
import com.kevinliu.springboogmallpractice.dto.CreateOrderRequest;
import com.kevinliu.springboogmallpractice.model.Order;
import com.kevinliu.springboogmallpractice.model.OrderItem;
import com.kevinliu.springboogmallpractice.model.Product;
import com.kevinliu.springboogmallpractice.repo.OrderDao;
import com.kevinliu.springboogmallpractice.repo.ProductRepo;
import com.kevinliu.springboogmallpractice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem: createOrderRequest.getBuyItemList()){
            Product product = productRepo.getProductById(buyItem.getProductId());

            // Calculate total amount
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // Convert BuyItem to OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        // Create Order
        Integer orderId = orderDao.createOrder(userId, totalAmount);
        orderDao.createOrderItem(orderId, orderItemList);

        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);
        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);
        order.setOrderItemList(orderItemList);

        return order;
    }
}

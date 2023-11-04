package com.kevinliu.springboogmallpractice.service.impl;

import com.kevinliu.springboogmallpractice.dto.BuyItem;
import com.kevinliu.springboogmallpractice.dto.CreateOrderRequest;
import com.kevinliu.springboogmallpractice.model.Order;
import com.kevinliu.springboogmallpractice.model.OrderItem;
import com.kevinliu.springboogmallpractice.model.Product;
import com.kevinliu.springboogmallpractice.model.User;
import com.kevinliu.springboogmallpractice.repo.OrderDao;
import com.kevinliu.springboogmallpractice.repo.ProductRepo;
import com.kevinliu.springboogmallpractice.repo.UserDao;
import com.kevinliu.springboogmallpractice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private UserDao userDao;

    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        // Check if the user exists
        User user = userDao.getUserById(userId);
        if (user == null){
            log.warn("UserId {} not exists", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem: createOrderRequest.getBuyItemList()){
            Product product = productRepo.getProductById(buyItem.getProductId());

            // Check if product exists and if stock is enough
            if (product == null) {
                log.warn("Product {} not exists", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else if (product.getStock() < buyItem.getQuantity()){
                log.warn("Product {} stock is not enough, current: {}, request: {}",
                        buyItem.getProductId(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            // Update product stock
            productRepo.updateStock(product.getProductId(), product.getStock() - buyItem.getQuantity());

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

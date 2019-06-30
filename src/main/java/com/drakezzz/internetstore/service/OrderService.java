package com.drakezzz.internetstore.service;


import com.drakezzz.internetstore.api.dto.OrderDto;
import com.drakezzz.internetstore.entity.Cart;
import com.drakezzz.internetstore.entity.Order;

import java.util.List;

public interface OrderService {

    public void saveOrder(Cart cart);

    public List<OrderDto> listClientOrders(String login);

    public List<Order> listOrderLines(Integer id);

    public void changeStatus(Long id, Integer statusCode);

    public List<OrderDto> listOrders();
}

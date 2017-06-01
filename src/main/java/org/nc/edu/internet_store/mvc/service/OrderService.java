package org.nc.edu.internet_store.mvc.service;


import org.nc.edu.internet_store.mvc.domain.Account;
import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.Order;

import java.util.List;

public interface OrderService {

    public void saveOrder(Cart cart);

    public List<Order> listClientOrders(String login);
}

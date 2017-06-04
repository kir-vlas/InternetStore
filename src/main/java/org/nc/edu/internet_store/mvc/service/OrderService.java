package org.nc.edu.internet_store.mvc.service;


import org.nc.edu.internet_store.mvc.domain.*;

import java.util.List;

public interface OrderService {

    public void saveOrder(Cart cart);

    public List<OrderList> listClientOrders(String login);

    public List<OrderLine> listOrderLines(Integer id);

    public void changeStatus(Integer id, Integer statusCode);

    public List<OrderList> listOrders();
}

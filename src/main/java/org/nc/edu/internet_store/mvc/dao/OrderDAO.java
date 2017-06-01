package org.nc.edu.internet_store.mvc.dao;

import org.nc.edu.internet_store.mvc.domain.*;

import java.util.List;

public interface OrderDAO {
    public void saveOrder(Cart cart);

    public List<OrderList> listOrderByClient(Account account);

    public Order findOrder(Integer id);
}

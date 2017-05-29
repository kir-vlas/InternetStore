package org.nc.edu.internet_store.mvc.dao;


import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.OrderLine;

import java.util.List;

public interface OrderDAO {
    public void saveOrder(Cart cart);

    public List<OrderLine> listOrderLine(Integer id);
}
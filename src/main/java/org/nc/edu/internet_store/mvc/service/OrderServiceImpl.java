package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.dao.OrderDAO;
import org.nc.edu.internet_store.mvc.domain.Account;
import org.nc.edu.internet_store.mvc.domain.Cart;
import org.nc.edu.internet_store.mvc.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO orderDAO;

    public void saveOrder(Cart cart, Account account){
        orderDAO.saveOrder(cart, account);
    }
}

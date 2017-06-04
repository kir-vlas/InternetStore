package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.dao.AccountDAO;
import org.nc.edu.internet_store.mvc.dao.OrderDAO;
import org.nc.edu.internet_store.mvc.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    AccountDAO accountDAO;

    public void saveOrder(Cart cart){
        orderDAO.saveOrder(cart);
    }

    public List<OrderList> listClientOrders(String login) {
        Account account = accountDAO.findAccount(login);
        return orderDAO.listOrderByClient(account);
    }

    public void changeStatus(Integer id, Integer statusCode){
        orderDAO.changeStatus(id, statusCode);
    }

    public List<OrderList> listOrders(){
        return orderDAO.listOrders();
    }

    public List<OrderLine> listOrderLines(Integer id){
        return orderDAO.listOrderLines(id);
    }
}

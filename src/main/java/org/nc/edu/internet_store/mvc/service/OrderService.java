package org.nc.edu.internet_store.mvc.service;


import org.nc.edu.internet_store.mvc.domain.Account;
import org.nc.edu.internet_store.mvc.domain.Cart;

public interface OrderService {

    public void saveOrder(Cart cart, Account account);
}

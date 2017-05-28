package org.nc.edu.internet_store.mvc.dao;

import org.nc.edu.internet_store.mvc.domain.Account;


public interface AccountDAO {
    public Account findAccount(String login);
}

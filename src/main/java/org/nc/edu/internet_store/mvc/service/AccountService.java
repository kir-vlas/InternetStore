package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.domain.Account;

public interface AccountService {
    public Account findAccount(String login);
}

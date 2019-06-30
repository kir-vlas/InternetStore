package com.drakezzz.internetstore.service;

import com.drakezzz.internetstore.api.dto.ShopClient;
import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.entity.Account;

public interface AccountService {

    public Account findAccount(String login);

    void createAccount(Account account);

    StatusResult registerClient(ShopClient client);

}

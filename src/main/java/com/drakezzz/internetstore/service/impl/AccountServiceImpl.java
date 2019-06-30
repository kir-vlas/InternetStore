package com.drakezzz.internetstore.service.impl;

import com.drakezzz.internetstore.api.dto.ShopClient;
import com.drakezzz.internetstore.api.dto.StatusResult;
import com.drakezzz.internetstore.entity.Account;
import com.drakezzz.internetstore.repository.AccountRepository;
import com.drakezzz.internetstore.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account findAccount(String login){
        return accountRepository.findByUsername(login);
    }

    @Override
    public void createAccount(Account account) {
        accountRepository.save(account);
    }

    @Override
    public StatusResult registerClient(ShopClient client) {
        Account account = Account.of(client);
        account.setActive(true);
        account.setRole("CLIENT");
        account.setRegisterDate(LocalDate.now());
        createAccount(account);
        return StatusResult.ok();
    }
}

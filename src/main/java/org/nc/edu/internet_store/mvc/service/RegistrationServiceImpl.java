package org.nc.edu.internet_store.mvc.service;

import org.nc.edu.internet_store.mvc.dao.AccountDAO;
import org.nc.edu.internet_store.mvc.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    AccountDAO accountDAO;

    public void createAccount(Account account){
        accountDAO.createAccount(account);
    }
}

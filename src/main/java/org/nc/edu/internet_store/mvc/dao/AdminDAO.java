package org.nc.edu.internet_store.mvc.dao;

import org.nc.edu.internet_store.mvc.domain.Administrator;

public interface AdminDAO {
    public Administrator findAdmin(String login);
}

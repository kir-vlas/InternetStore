package org.nc.edu.internet_store.mvc.dao;

import org.nc.edu.internet_store.mvc.domain.AuthorizedClient;

public interface ClientDAO {
    public AuthorizedClient findClient(String login);
}

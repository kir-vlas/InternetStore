package org.nc.edu.internet_store.mvc.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nc.edu.internet_store.mvc.domain.AuthorizedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
public class ClientDAOImpl implements ClientDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public AuthorizedClient findClient(String login){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String query = "from AuthorizedClient where login = " + login;
        AuthorizedClient client = (AuthorizedClient) session.createQuery(query).getSingleResult();
        return client;
    }
}

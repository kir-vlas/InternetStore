package org.nc.edu.internet_store.mvc.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.nc.edu.internet_store.mvc.domain.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDAOImpl implements AdminDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public Administrator findAdmin(String login){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        String query = "from AuthorizedClient where login = " + login;
        Administrator admin = (Administrator) session.createQuery(query).getSingleResult();
        return admin;
    }

}

package org.nc.edu.internet_store.mvc.dao;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.nc.edu.internet_store.mvc.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Repository
public class AccountDAOImpl implements AccountDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public Account findAccount(String login){
        Session session = sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive())session.beginTransaction();
        Criteria crit = session.createCriteria(Account.class);
        crit.add(Restrictions.eq("login", login));
        Account acc = (Account) crit.uniqueResult();
        session.close();
        return acc;
    }

    public void createAccount(Account account){
        Session session = sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive())session.beginTransaction();
        session.save(account);
        session.close();
    }
}

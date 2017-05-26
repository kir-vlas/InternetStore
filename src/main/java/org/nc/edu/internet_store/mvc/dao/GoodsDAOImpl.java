package org.nc.edu.internet_store.mvc.dao;

import org.hibernate.Session;
import org.nc.edu.internet_store.mvc.domain.Good;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

@Repository
public class GoodsDAOImpl implements GoodsDAO{
    @Autowired
    private SessionFactory sessionFactory;

    public void addGood(Good good){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(good);
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Good> listGood(){
        String query = "select g from Good g inner join g.category";
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Good> list = session.createQuery(query).list();
        session.close();
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Good> listGood(Integer id){
        String query = "select g from Good g inner join g.category where g.category = " + id.toString();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Good> list = session.createQuery(query).list();
        session.close();
        return list;
    }

    public void deleteGood(Integer id){
        throw new NotImplementedException();
    }
}

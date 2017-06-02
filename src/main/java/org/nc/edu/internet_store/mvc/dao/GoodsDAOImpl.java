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
        if (!session.getTransaction().isActive())session.beginTransaction();
        session.save(good);
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Good> listGood(){
        String query = "select g from Good g inner join g.category";
        Session session = sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive())session.beginTransaction();
        List<Good> list = session.createQuery(query).list();
        session.close();
        return list;
    }

    @SuppressWarnings("unchecked")
    public List<Good> listGoodByCategory(Integer id){
        String query = "select g from Good g inner join g.category where g.category = " + id.toString();
        Session session = sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive())session.beginTransaction();
        List<Good> list = session.createQuery(query).list();
        session.close();
        return list;
    }

    public void updateGood(Good good){
        String query = "select g from Good g where g.id = " + good.getId().toString();
        Session session = sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive())session.beginTransaction();
        Good oldGood = (Good) session.createQuery(query).list().get(0);
        oldGood.setTitle(good.getTitle());
        oldGood.setPrice(good.getPrice());
        oldGood.setDescription(good.getDescription());
        session.flush();
        session.close();
    }

    public Good listGoodById(Integer id){
        String query = "select g from Good g inner join g.category where g.id = " + id.toString();
        Session session = sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive())session.beginTransaction();
        List<Good> list = session.createQuery(query).list();
        session.close();
        return list.get(0);
    }

    public void deleteGood(Integer id){
        Session session = sessionFactory.getCurrentSession();
        if (!session.getTransaction().isActive())session.beginTransaction();
        Query query = session.createQuery("delete from Good where id = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        session.close();
    }
}

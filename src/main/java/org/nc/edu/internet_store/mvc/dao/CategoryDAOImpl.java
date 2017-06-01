package org.nc.edu.internet_store.mvc.dao;

import org.hibernate.Session;
import org.nc.edu.internet_store.mvc.domain.Category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;

@Repository
public class CategoryDAOImpl implements CategoryDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCategory(Category category){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.save(category);
        session.close();
    }

    @SuppressWarnings("unchecked")
    public List<Category> listCategory() {
        String query = "    from Category ";
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        List<Category> list = session.createQuery(query).list();
        session.close();
        return list;
    }

    public Category findCategoryById(Integer id){
        String query = "select c from Category c where c.id = " + id.toString();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Category category = (Category) session.createQuery(query).list().get(0);
        return category;
    }

    public void updateCategory(Integer id, String cat){
        String query = "select c from Category c where c.id = " + id.toString();
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Category category = (Category) session.createQuery(query).list().get(0);
        category.setCategory(cat);
        session.flush();
        session.close();
    }

    public void removeCategory(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        //Category category = session.load(Category.class, id);
        Query query = session.createQuery("delete from Category where id = :id");
        query.setParameter("id",id);
        query.executeUpdate();
        session.close();
    }
}

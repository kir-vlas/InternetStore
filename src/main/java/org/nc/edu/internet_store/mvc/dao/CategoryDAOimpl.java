package org.nc.edu.internet_store.mvc.dao;

import org.nc.edu.internet_store.mvc.domain.Category;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDAOimpl implements CategoryDAO{

    @Autowired
    private SessionFactory sessionFactory;

    public void addCategory(Category category){
        sessionFactory.getCurrentSession().save(category);
    }

    @SuppressWarnings("unchecked")
    public List<Category> listCategory() {
        String query = "";
        return sessionFactory.getCurrentSession().createQuery("select cat from Category cat").list();
    }

    public void removeCategory(Integer id) {
        Category category = (Category) sessionFactory.getCurrentSession().load(Category.class, id);
        if (null != category) {
            sessionFactory.getCurrentSession().delete(category);
        }

    }
}

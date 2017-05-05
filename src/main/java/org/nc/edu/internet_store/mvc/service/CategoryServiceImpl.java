package org.nc.edu.internet_store.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.nc.edu.internet_store.mvc.dao.CategoryDAO;
import org.nc.edu.internet_store.mvc.domain.Category;


@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryDAO categoryDAO;

    @Transactional
    public void addCategory(Category category){
        categoryDAO.addCategory(category);
    }

    @Transactional
    public List<Category> listCategory(){
        return categoryDAO.listCategory();
    }

    @Transactional
    public void removeCategory(Integer id){
        categoryDAO.removeCategory(id);
    }
}

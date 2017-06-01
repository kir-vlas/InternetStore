package org.nc.edu.internet_store.mvc.dao;

import org.nc.edu.internet_store.mvc.domain.Category;
import java.util.List;

public interface CategoryDAO {
    public void addCategory(Category category);

    public List<Category> listCategory();

    public Category findCategoryById(Integer id);

    public void updateCategory(Integer id, String cat);

    public void removeCategory(Integer id);
}

package com.drakezzz.internetstore.service;

import com.drakezzz.internetstore.api.dto.CategoryDto;
import com.drakezzz.internetstore.entity.GoodCategory;

import java.util.List;

public interface CategoryService {

    public void addCategory(GoodCategory category);

    public List<CategoryDto> listCategory();

    public GoodCategory findCategoryById(Long id);

    public void updateCategory(GoodCategory category);

    public void removeCategory(Long id);
}
